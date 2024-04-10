package screenmatch;

import ext.domain.screenmatch.models.Movie;

public class ScreenMatch {

    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.setName("The Pianist");
        movie1.setDateRelease(2002);
        movie1.setDuration(150);
        movie1.setEnable(true);
        movie1.evaluate(4.9);
        movie1.evaluate(4.8);
        movie1.evaluate(4.7);
        movie1.evaluate(4.6);
        movie1.evaluate(4.5);
        movie1.calculateAverage();
        movie1.showDataSheet();
        System.out.println("*************************************************");
        Movie movie2 = new Movie();
        movie2.setName("Man on Fire");
        movie2.setDateRelease(2004);
        movie2.setDuration(146);
        movie2.setEnable(false);
        movie2.evaluate(4.49);
        movie2.evaluate(4.25);
        movie2.evaluate(4);
        movie2.calculateAverage();
        movie2.showDataSheet();
        System.out.println("*************************************************");
    }
}