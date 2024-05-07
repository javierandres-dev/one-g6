package ext.domain.screenmatch.main;

import ext.domain.screenmatch.model.Episode;
import ext.domain.screenmatch.model.EpisodeData;
import ext.domain.screenmatch.model.SeasonData;
import ext.domain.screenmatch.model.SerieData;
import ext.domain.screenmatch.service.ConsumptionAPI;
import ext.domain.screenmatch.service.ConvertData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private ConsumptionAPI consumptionApi = new ConsumptionAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=API_KEY";
    private ConvertData convertData = new ConvertData();

    public  void showMenu(){
        // get data general
        System.out.print("Enter serie name to search: ");
        String serie = sc.nextLine();
        System.out.println("serie: " + serie);
        var json = consumptionApi.getData(URL_BASE + serie.replace(" ", "+") + API_KEY);
        System.out.println("json: " + json);
        var serieData = convertData.getData(json, SerieData.class);
        System.out.println("serieData: " + serieData);

        // get data by season
        List<SeasonData> seasons = new ArrayList<>();
        System.out.println("seasons: " + seasons);
        for (int i = 1; i <= serieData.seasons() ; i++) {
            json = consumptionApi.getData(URL_BASE + serie.replace(" ", "+") + "&Season=" + i + API_KEY);
            var seasonData = convertData.getData(json, SeasonData.class);
            System.out.println("seasonData: " + seasonData);
            seasons.add(seasonData);
        }
        System.out.println("seasons: " + seasons);
        seasons.forEach(System.out::println);

        // show title - without lambda
        /*
        for (int i = 0; i < serieData.seasons(); i++) {
            List<EpisodeData> episodes = seasons.get(i).episodes();
            for (int j = 0; j < episodes.size(); j++) {
                System.out.println("episode: " + episodes.get(j).title());
            }
        }
        */

        // show title - with lambda
        seasons.forEach(season -> season.episodes().forEach(episode -> System.out.println("episode: " + episode.title())));

        List<EpisodeData> episodeData = seasons.stream()
                .flatMap(season -> season.episodes().stream())
                //.toList();
                .collect(Collectors.toList());

        // get top five
        System.out.println("Top five episodes: ");
        episodeData.stream()
                .filter(episode -> !episode.rating().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("First - filter: " + e))
                .sorted(Comparator.comparing(EpisodeData::rating).reversed())
                .peek(e -> System.out.println("Second - sorted: " + e))
                .map(e -> e.title().toUpperCase())
                .peek(e -> System.out.println("Third - map: " + e))
                .limit(5)
                .peek(e -> System.out.println("Fourth - limit: " + e))
                .forEach(System.out::println);

        // convert data to list
        List<Episode> episodes = seasons.stream()
                .flatMap(season -> season.episodes().stream()
                        .map(item -> new Episode(item.episode(), item)))
                .collect(Collectors.toList());
        episodes.forEach(System.out::println);

        // search episode by year
        System.out.print("Enter a year to search: ");
        var date = sc.nextInt();
        sc.nextLine();
        LocalDate dateSearch = LocalDate.of(date, 1, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodes.stream()
                .filter(episode -> episode.getReleased() != null && episode.getReleased().isAfter(dateSearch))
                .forEach(episode -> System.out.println(
                        "Released: " + episode.getReleased().format(dtf) +
                        "\tSeason: " + episode.getSeason() +
                        "\tEpisode: " + episode.getTitle()
                ));

        // search episode by title piece
        System.out.print("Enter title piece to search: ");
        var titlePiece = sc.nextLine();
        Optional<Episode> episodeFound = episodes.stream()
                .filter(e -> e.getTitle().toUpperCase().contains(titlePiece.toUpperCase()))
                .findFirst();
        if (episodeFound.isPresent()){
            System.out.println("Episode found: " + episodeFound.get());
        } else {
            System.out.println("Episode not found");
        }

        //
        /*Map<Integer, Double> ratingsBySeason = episodes.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.groupingBy(Episode::getSeason,
                        Collectors.averagingDouble(Episode::getRating)));
        System.out.println("Ratings by season: " + ratingsBySeason);*/

        // statistics
        DoubleSummaryStatistics statistics = episodes.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.summarizingDouble(Episode::getRating));
        System.out.println("statistics: " + statistics);
        System.out.println("average: " + statistics.getAverage());
        System.out.println("max: " + statistics.getMax());
        System.out.println("min: " + statistics.getMin());
    }
}
