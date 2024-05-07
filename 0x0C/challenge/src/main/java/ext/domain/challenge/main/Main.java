package ext.domain.challenge.main;


import ext.domain.challenge.model.BooksData;
import ext.domain.challenge.model.Data;
import ext.domain.challenge.service.ConsumptionAPI;
import ext.domain.challenge.service.ConvertData;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private final String URL_BASE = "https://gutendex.com/books/";

    private ConsumptionAPI consumptionApi = new ConsumptionAPI();
    private ConvertData convertData = new ConvertData();
    private Scanner sc = new Scanner(System.in);

    public  void showMenu(){
        var json = consumptionApi.getData(URL_BASE);
        System.out.println("json: " + json);
        var data = convertData.getData(json, Data.class);
        System.out.println("data: " + data);

        // top ten
        System.out.println("Top 10");
        data.results().stream()
                .sorted(Comparator.comparing(BooksData::downloads).reversed())
                .limit(10)
                .map(book -> book.title().toUpperCase())
                .forEach(System.out::println);

        // stats
        DoubleSummaryStatistics stats = data.results().stream()
                .filter(item -> item.downloads() > 0)
                .collect(Collectors.summarizingDouble(BooksData::downloads));
        System.out.println("stats: " + stats);
        System.out.println("average: " + stats.getAverage());
        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("records: " + stats.getCount());

        // search by title
        System.out.print("Enter book title to search: ");
        var titleBook = sc.nextLine();
        var jsonSearch = consumptionApi.getData(URL_BASE + "?search=" + titleBook.replace(" ", "+"));
        System.out.println("jsonSearch: " + jsonSearch);
        var dataSearch = convertData.getData(jsonSearch, Data.class);
        System.out.println("dataSearch: " + dataSearch);
        Optional<BooksData> bookFound = dataSearch.results().stream()
                .filter(book -> book.title().toUpperCase().contains(titleBook.toUpperCase()))
                .findFirst();
        if(bookFound.isPresent()){
            System.out.println("Book found: " + bookFound.get());
        } else {
            System.out.println("Book not found");
        }
    }
}
