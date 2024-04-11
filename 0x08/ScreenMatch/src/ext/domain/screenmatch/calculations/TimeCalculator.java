package ext.domain.screenmatch.calculations;
import ext.domain.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }
    
    public void add(Title title){
        this.totalTime += title.getDuration();
    }
}
