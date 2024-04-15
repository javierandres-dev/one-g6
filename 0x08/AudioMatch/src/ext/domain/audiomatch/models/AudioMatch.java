package ext.domain.audiomatch.models;

public class AudioMatch {
    private String title;
    private int reproductions;
    private int likes;
    private int classification;

    public void reproduction(){
        this.reproductions++;
    }

    public void like(){
        this.likes++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReproductions() {
        return reproductions;
    }

    public void setReproductions(int reproductions) {
        this.reproductions = reproductions;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }
}
