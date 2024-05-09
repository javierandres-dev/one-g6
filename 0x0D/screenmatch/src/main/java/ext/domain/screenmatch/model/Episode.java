package ext.domain.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer episode;
    private Double rating;
    private LocalDate released;

    public Episode(Integer number, EpisodeData item) {
        this.season = number;
        this.title = item.title();
        this.episode = item.episode();
        try {
            this.rating = Double.valueOf(item.rating());
        }catch (NumberFormatException e){
            this.rating = 0.0;
        }
        try {
            this.released = LocalDate.parse(item.released());
        }catch (DateTimeParseException e){
            this.rating = null;
        }
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "season=" + season +
                ", title='" + title + '\'' +
                ", episode=" + episode +
                ", rating=" + rating +
                ", released=" + released +
                '}';
    }
}
