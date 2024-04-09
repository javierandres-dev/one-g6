package screenmatch;

public class ScreenMatch {

    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.name = "The Pianist";
        movie1.dateRelease = 2002;
        movie1.duration = 150;
        movie1.enable = true;
        movie1.evaluate(4.9);
        movie1.evaluate(4.8);
        movie1.evaluate(4.7);
        movie1.evaluate(4.6);
        movie1.evaluate(4.5);
        movie1.calculateAverage();
        movie1.showDataSheet();
        
        Movie movie2 = new Movie();
        movie2.name = "Man on Fire";
        movie2.dateRelease = 2004;
        movie2.duration = 146;
        movie2.enable = false;
        movie2.evaluate(4.49);
        movie2.evaluate(4.25);
        movie2.evaluate(4);
        movie2.calculateAverage();
        movie2.showDataSheet();
    }
    
}
