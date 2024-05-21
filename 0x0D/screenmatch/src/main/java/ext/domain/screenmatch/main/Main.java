package ext.domain.screenmatch.main;

import ext.domain.screenmatch.model.*;
import ext.domain.screenmatch.repository.SerieRepository;
import ext.domain.screenmatch.service.ConsumptionAPI;
import ext.domain.screenmatch.service.ConvertData;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private ConsumptionAPI consumptionApi = new ConsumptionAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a0858938";
    private ConvertData convertData = new ConvertData();
    private List<SerieData> seriesData = new ArrayList<>();
    private SerieRepository serieRepository;
    private List<Serie> series;

    public Main(SerieRepository repository) {
        this.serieRepository = repository;
    }

    public void showMenu() {
        System.out.println("START************************************************************************************");
        // get data general
        /*System.out.print("Enter serie name to search: ");
        String serie = sc.nextLine();
        System.out.println("serie: " + serie);
        var json = consumptionApi.getData(URL_BASE + serie.replace(" ", "+") + API_KEY);
        System.out.println("json: " + json);
        var serieData = convertData.getData(json, SerieData.class);
        System.out.println("serieData: " + serieData);*/

        // get data by season
        /*List<SeasonData> seasons = new ArrayList<>();
        System.out.println("seasons: " + seasons);
        for (int i = 1; i <= serieData.seasons() ; i++) {
            json = consumptionApi.getData(URL_BASE + serie.replace(" ", "+") + "&Season=" + i + API_KEY);
            var seasonData = convertData.getData(json, SeasonData.class);
            System.out.println("seasonData: " + seasonData);
            seasons.add(seasonData);
        }
        System.out.println("seasons: " + seasons);
        seasons.forEach(System.out::println);*/

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
        /*seasons.forEach(season -> season.episodes().forEach(episode -> System.out.println("episode: " + episode.title())));

        List<EpisodeData> episodeData = seasons.stream()
                .flatMap(season -> season.episodes().stream())
                //.toList();
                .collect(Collectors.toList());*/

        // get top five
        /*System.out.println("Top five episodes: ");
        episodeData.stream()
                .filter(episode -> !episode.rating().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("First - filter: " + e))
                .sorted(Comparator.comparing(EpisodeData::rating).reversed())
                .peek(e -> System.out.println("Second - sorted: " + e))
                .map(e -> e.title().toUpperCase())
                .peek(e -> System.out.println("Third - map: " + e))
                .limit(5)
                .peek(e -> System.out.println("Fourth - limit: " + e))
                .forEach(System.out::println);*/

        // convert data to list
        /*List<Episode> episodes = seasons.stream()
                .flatMap(season -> season.episodes().stream()
                        .map(item -> new Episode(item.episode(), item)))
                .collect(Collectors.toList());
        episodes.forEach(System.out::println);*/

        // search episode by year
        /*System.out.print("Enter a year to search: ");
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
                ));*/

        // search episode by title piece
        /*System.out.print("Enter title piece to search: ");
        var titlePiece = sc.nextLine();
        Optional<Episode> episodeFound = episodes.stream()
                .filter(e -> e.getTitle().toUpperCase().contains(titlePiece.toUpperCase()))
                .findFirst();
        if (episodeFound.isPresent()){
            System.out.println("Episode found: " + episodeFound.get());
        } else {
            System.out.println("Episode not found");
        }*/

        //
        /*Map<Integer, Double> ratingsBySeason = episodes.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.groupingBy(Episode::getSeason,
                        Collectors.averagingDouble(Episode::getRating)));
        System.out.println("Ratings by season: " + ratingsBySeason);*/

        // statistics
        /*DoubleSummaryStatistics statistics = episodes.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.summarizingDouble(Episode::getRating));
        System.out.println("statistics: " + statistics);
        System.out.println("average: " + statistics.getAverage());
        System.out.println("max: " + statistics.getMax());
        System.out.println("min: " + statistics.getMin());*/

        // new menu
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Search serie
                    2 - Search episode
                    3 - View searched series
                                        
                    0 - Exit
                    """;
            System.out.println(menu);
            System.out.print("Option: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("search serie...");
                    searchSerie();
                    break;
                case 2:
                    System.out.println("search episode...");
                    searchEpisode();
                    break;
                case 3:
                    System.out.println("view searched series...");
                    viewSearchedSeries();
                    break;
                case 0:
                    System.out.println("ending application...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        System.out.println("**************************************************************************************END");
    }

    private SerieData getSerieData() {
        System.out.print("Enter serie name to search: ");
        String serie = sc.nextLine();
        System.out.println("serie: " + serie);
        var json = consumptionApi.getData(URL_BASE + serie.replace(" ", "+") + API_KEY);
        System.out.println("json: " + json);
        var serieData = convertData.getData(json, SerieData.class);
        System.out.println("serieData: " + serieData);
        return serieData;
    }

    private void searchEpisode() {
        //SerieData serieData = getSerieData();
        viewSearchedSeries();
        System.out.println("Enter serie name: ");
        var serieName = sc.nextLine();
        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitle().toLowerCase().contains(serieName.toLowerCase()))
                .findFirst();
        if (serie.isPresent()){
            var serieFound = serie.get();
            List<SeasonData> seasons = new ArrayList<>();
            System.out.println("seasons: " + seasons);
            for (int i = 1; i <= serieFound.getSeasons(); i++) {
                var json = consumptionApi.getData(URL_BASE + serieFound.getTitle().replace(" ", "+") + "&Season=" + i + API_KEY);
                var seasonData = convertData.getData(json, SeasonData.class);
                System.out.println("seasonData: " + seasonData);
                seasons.add(seasonData);
            }
            System.out.println("seasons: " + seasons);
            seasons.forEach(System.out::println);
            List<Episode> episodes = seasons.stream()
                    .flatMap(d -> d.episodes().stream()
                            .map(e -> new Episode(d.season(), e)))
                    .collect(Collectors.toList());
            serieFound.setEpisodes(episodes);
            serieRepository.save(serieFound);
        }
        /* List<SeasonData> seasons = new ArrayList<>();
        System.out.println("seasons: " + seasons);
        for (int i = 1; i <= serieData.seasons(); i++) {
            var json = consumptionApi.getData(URL_BASE + serieData.title().replace(" ", "+") + "&Season=" + i + API_KEY);
            var seasonData = convertData.getData(json, SeasonData.class);
            System.out.println("seasonData: " + seasonData);
            seasons.add(seasonData);
        }
        System.out.println("seasons: " + seasons);
        seasons.forEach(System.out::println); */
    }

    private void searchSerie() {
        SerieData data = getSerieData();
        System.out.println("data: " + data);
        //seriesData.add(data);
        Serie serie = new Serie(data);
        System.out.println("serie: " + serie);
        serieRepository.save(serie);
    }

    private void viewSearchedSeries() {
        //seriesData.forEach(System.out::println);
        /*List<Serie> series = new ArrayList<>();
        series = seriesData.stream()
                .map(item -> new Serie(item))
                .collect(Collectors.toList());*/

        //List<Serie> series = serieRepository.findAll();
        series = serieRepository.findAll();
        series.stream()
        .sorted(Comparator.comparing(Serie::getGenre))
        .forEach(System.out::println);

    }
}
