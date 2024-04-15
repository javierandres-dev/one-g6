package ext.domain.audiomatch.models;

public class Song extends AudioMatch {
    private String artist;
    private String album;
    private String genre;

    @Override
    public int getClassification() {
        if (getLikes() > 900){
            return 8;
        }else {
            return 4;
        }
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}