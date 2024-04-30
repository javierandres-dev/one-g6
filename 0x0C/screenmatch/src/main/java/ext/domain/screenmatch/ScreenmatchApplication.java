package ext.domain.screenmatch;

import ext.domain.screenmatch.service.ConsumptionAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println("Hello, World! from Spring");
		var consumptionApi = new ConsumptionAPI();
		var json = consumptionApi.getData("https://www.omdbapi.com/?t=the+big+bang+theory&apikey=a0858938");
		// https://coffee.alexflipnote.dev/random.json
		System.out.println("json: " + json);
	}
}
