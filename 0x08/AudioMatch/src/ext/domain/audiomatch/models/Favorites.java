package ext.domain.audiomatch.models;

public class Favorites {
    public void add(AudioMatch audio){
        if (audio.getClassification() >= 8 ) {
            System.out.println("\tThe title " + audio.getTitle() + ", is favorite");
        } else {
            System.out.println("\tThe title " + audio.getTitle() + ", isn't favorite");
        }
    }
}
