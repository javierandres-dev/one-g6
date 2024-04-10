package ext.domain.screenmatch.models;

public class Movie {
    private String name;
    private int dateRelease;
    private int duration;
    private boolean enable;
    private double score = 0;
    private int votes = 0;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDateRelease(int dateRelease){
        this.dateRelease = dateRelease;
    }
    
    public void setDuration(int duration){
        this.duration = duration;
    }
    
    public void setEnable(boolean enable){
        this.enable = enable;
    }
    
    public String getName(){
        return name;
    }
    
    public int getDateRelease(){
        return dateRelease;
    }
    
    public int getDuration(){
        return duration;
    }
    
    public boolean getEnable(){
        return enable;
    }
    
    public int getVotes(){
        return votes;
    }
    
    public void showDataSheet(){
        System.out.println("=================================================");
        System.out.println("\tTitle: " + name);
        System.out.println("\tDate release: " + dateRelease);
        System.out.println("\tDuration: " + duration + " minutes");
        System.out.println("\tAvailable: " + enable);
        System.out.println("\tAverage score: " + calculateAverage());
    }
    
    public void evaluate(double qualification){
        score += qualification;
        votes++;
        System.out.println("Votes: " + votes + ", Score: " + score);
    }
    
    public double calculateAverage(){
        return score / votes;
    }
}
