package ext.domain.screenmatch;

import ext.domain.screenmatch.main.Main;
import ext.domain.screenmatch.main.StreamsSample;
import ext.domain.screenmatch.model.EpisodeData;
import ext.domain.screenmatch.model.SeasonData;
import ext.domain.screenmatch.model.SerieData;
import ext.domain.screenmatch.service.ConsumptionAPI;
import ext.domain.screenmatch.service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		System.out.println("Hello, World! from Spring");

		var consumptionApi = new ConsumptionAPI();
		var json = consumptionApi.getData("https://www.omdbapi.com/?t=the+big+bang+theory&apikey=API_KEY");
		System.out.println("json: " + json);
		ConvertData convertData = new ConvertData();
		var serieData = convertData.getData(json, SerieData.class);
		System.out.println("serieData: " + serieData);
		json = consumptionApi.getData("https://www.omdbapi.com/?t=the+big+bang+theory&Season=1&episode=1&apikey=API_KEY");
		System.out.println("json: " + json);
		var episodeData = convertData.getData(json, EpisodeData.class);
		System.out.println("episodeData: " + episodeData);

		List<SeasonData> seasons = new ArrayList<>();
		System.out.println("seasons: " + seasons);
		for (int i = 1; i <= serieData.seasons() ; i++) {
			json = consumptionApi.getData("https://www.omdbapi.com/?t=the+big+bang+theory&Season=" + i + "&apikey=API_KEY");
			var seasonData = convertData.getData(json, SeasonData.class);
			System.out.println("seasonData: " + seasonData);
			seasons.add(seasonData);
		}
		System.out.println("seasons: " + seasons);
		seasons.forEach(System.out::println);
		*/
		Main main = new Main();
		main.showMenu();
		/*
		StreamsSample streamsSample = new StreamsSample();
		streamsSample.showSample();
		*/
	}
}
