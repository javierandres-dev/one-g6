package ext.domain.screenmatch.main;

import java.util.Arrays;
import java.util.List;

public class StreamsSample {
    public  void showSample(){
        List<String> names = Arrays.asList("John", "Jane", "Pepita", "Olivia", "James", "William", "Daniel", "Emma");
        names.stream()
                .sorted()
                .filter(i -> i.startsWith(("J")))
                .map(i -> i.toUpperCase())
                .limit(10)
                .forEach(System.out::println);
    }
}
