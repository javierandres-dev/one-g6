package ext.domain.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record SeasonData(
        @JsonAlias("Season") Integer season,
        @JsonAlias("Episodes") List<EpisodeData> episodes
) {
}
