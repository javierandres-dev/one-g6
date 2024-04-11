package ext.domain.screenmatch.calculations;

public class Recommendations {
    public void filter(Classification classification){
        if(classification.getClassification() >= 4.75){
            System.out.println("Excellent");
        } else if(classification.getClassification() >= 4){
            System.out.println("Good");
        } else if(classification.getClassification() >= 3){
            System.out.println("Fair");
        } else if(classification.getClassification() >= 2){
            System.out.println("Poor");
        } else {
            System.out.println("Bad");
        }
    }
}
