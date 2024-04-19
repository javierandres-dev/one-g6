import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // final String apiUrl = "https://www.omdbapi.com/?i=tt0898266&apikey=a0858938";
        final String apiUrl = "https://www.omdbapi.com/?t=the+big+bang+theory&apikey=a0858938";

        // HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
        // HttpResponse
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        // Gson
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        MyRecord myRecord = gson.fromJson(json, MyRecord.class);
        System.out.println(myRecord);
    }
}
