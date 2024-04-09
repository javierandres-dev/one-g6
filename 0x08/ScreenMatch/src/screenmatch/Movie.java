package screenmatch;

public class Movie {
    String name;
    int dateRelease;
    int duration;
    boolean enable;
    double score = 0;
    int votes = 0;
    
    void showDataSheet(){
        System.out.println("*************************************************");
        System.out.println("\tTitle: " + name);
        System.out.println("\tDate release: " + dateRelease);
        System.out.println("\tDuration: " + duration + " minutes");
        System.out.println("\tAvailable: " + enable);
        System.out.println("\tAverage score: " + calculateAverage());
        System.out.println("*************************************************");
    }
    
    void evaluate(double qualification){
        score += qualification;
        votes++;
        System.out.println("Votes: " + votes + ", Score: " + score);
    }
    
    double calculateAverage(){
        return score / votes;
    }
}
