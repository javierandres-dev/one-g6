package ext.domain.screenmatch.model;

import ext.domain.screenmatch.service.RequestChatGPT;

import java.util.OptionalDouble;

public class Serie {
    private String title;
    private Integer seasons;
    private Double rating;
    private String poster;
    private Category genre;
    private String actors;
    private String synopsis;

    public Serie(SerieData serieData) {
        this.title = serieData.title();
        this.seasons = serieData.seasons();
        this.rating = OptionalDouble.of(Double.valueOf(serieData.rating())).orElse(0);
        this.poster = serieData.poster();
        this.genre = Category.fromString(serieData.genre().split(",")[0].trim());
        this.actors = serieData.actors();
        this.synopsis = serieData.synopsis();
//        this.synopsis = RequestChatGPT.getTranslation(serieData.synopsis());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "genre=" + genre + '\'' +
                ", title='" + title + '\'' +
                ", seasons=" + seasons + '\'' +
                ", rating=" + rating + '\'' +
                ", poster='" + poster + '\'' +
                ", actors='" + actors + '\'' +
                ", synopsis='" + synopsis + '\'';
    }
}