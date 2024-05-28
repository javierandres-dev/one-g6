package ext.domain.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record SerieData(
        @JsonAlias("Title") String title,
        @JsonAlias("totalSeasons") Integer seasons,
        @JsonAlias("imdbRating") String rating,
        @JsonAlias("Poster") String poster,
        @JsonAlias("Genre") String genre,
        @JsonAlias("Actors") String actors,
        @JsonAlias("Plot") String synopsis) {
}