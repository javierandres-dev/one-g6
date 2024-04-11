package ext.domain.screenmatch.models;

public class Title {
    private String type;
    private String name;
    private int dateRelease;
    private int duration;
    private boolean enable;
    private double score = 0;
    private int votes = 0;

    /*public String getType() {
        return type;
    }*/

    public void setType(String type) {
        this.type = type;
    }
    
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
        System.out.println("\tType: " + type);
        System.out.println("\tName: " + name);
        System.out.println("\tDate release: " + dateRelease);
        System.out.println("\tDuration: " + getDuration() + " minutes");
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
