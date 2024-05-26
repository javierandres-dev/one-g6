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
    private Optional<Serie> serieFound;

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
                    \t** MENU **
                    \t1 - Search serie
                    \t2 - Search episode
                    \t3 - View searched series
                    \t4 - Search serie by title
                    \t5 - Top 5 best series
                    \t6 - Search serie by genre
                    \t7 - Buscar serie por género
                    \t8 - Filter series
                    \t9 - Search episode by title
                    \t10 - Top 5 episodes by serie\n
                    \t0 - Exit
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
                case 4:
                    System.out.println("search serie by title ...");
                    searchSerieByTitle();
                    break;
                case 5:
                    System.out.println("top 5 best series ...");
                    searchTop5Series();
                    break;
                case 6:
                    System.out.println("search serie by genre ...");
                    searchSerieByGenre();
                    break;
                case 7:
                    System.out.println("buscar serie por género ...");
                    searchSerieByGenreSpanish();
                    break;
                case 8:
                    System.out.println("filter series ...");
                    filterSeriesBySeasonAndRating();
                    break;
                case 9:
                    System.out.println("search episode by title ...");
                    searchEpisodesByTitle();
                    break;
                case 10:
                    System.out.println("top 5 episodes by serie ...");
                    searchTop5EpisodesBySerie();
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

    private void searchSerieByTitle(){
        System.out.println("Enter serie title: ");
        var serieTitle = sc.nextLine();
        serieFound = serieRepository.findByTitleContainsIgnoreCase(serieTitle);
        if (serieFound.isPresent()){
            System.out.println("Serie found: " + serieFound.get());
        } else {
            System.out.println("Serie '" + serieTitle + "' not found");
        }
    }

    private void searchTop5Series(){
        List<Serie> topSeries = serieRepository.findTop5ByOrderByRatingDesc();
        topSeries.forEach(s -> System.out.println("Title: "  + s.getTitle() +  " | Rating: " + s.getRating()));
    }

    private void searchSerieByGenre(){
        System.out.println("Enter serie genre: ");
        var serieGenre = sc.nextLine();
        var category = Category.fromString(serieGenre);
        List<Serie> seriesByGenre = serieRepository.findByGenre(category);
        System.out.println("Series of genre: " + serieGenre);
        seriesByGenre.forEach(System.out::println);
    }

    private void searchSerieByGenreSpanish(){
        System.out.println("Ingrese el género: ");
        var serieGenre = sc.nextLine();
        var category = Category.fromSpanish(serieGenre);
        List<Serie> seriesByGenre = serieRepository.findByGenre(category);
        System.out.println("Series de género: " + serieGenre);
        seriesByGenre.forEach(System.out::println);
    }

    private void filterSeriesBySeasonAndRating(){
        System.out.println("Enter number of seasons: ");
        var inSeasons = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter minimum rating: ");
        var inRating = sc.nextDouble();
        sc.nextLine();
        //List<Serie> filtered = serieRepository.findBySeasonsLessThanEqualAndRatingGreaterThanEqual(inSeasons, inRating);
        //List<Serie> filtered = serieRepository.seriesBySeasonAndRating();
        List<Serie> filtered = serieRepository.seriesBySeasonAndRating(inSeasons, inRating);
        System.out.println("*** Series filtered ***");
        filtered.forEach(s ->
                System.out.println(s.getTitle() + "  - rating: " + s.getRating()));
    }

    private void searchEpisodesByTitle(){
        System.out.println("Enter episode name: ");
        var episodename = sc.nextLine();
        List<Episode> episodesFound = serieRepository.episodeByname(episodename);
        episodesFound.forEach(e ->
                System.out.printf("Serie: %s | Season: %s | Episode: %s | Rating: %s\n",
                        e.getSerie().getTitle(), e.getSeason(), e.getEpisode(), e.getRating()));
    }

    private void searchTop5EpisodesBySerie(){
        searchSerieByTitle();
        if (serieFound.isPresent()) {
            Serie serie = serieFound.get();
            System.out.println("serie: " + serie);
            List<Episode> topEpisodes = serieRepository.top5Episodes(serie);
            System.out.println("topEpisodes: " + topEpisodes);
            topEpisodes.forEach(e ->
                    System.out.printf("Serie: %s | Season: %s | Episode: %s | Rating: %s\n",
                            e.getSerie().getTitle(), e.getSeason(), e.getTitle(), e.getRating()));
        }
    }
}
