package ext.domain.screenmatch.repository;

import ext.domain.screenmatch.dto.EpisodeDTO;
import ext.domain.screenmatch.model.Category;
import ext.domain.screenmatch.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import ext.domain.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTitleContainsIgnoreCase(String serieTitle);
    List<Serie> findTop5ByOrderByRatingDesc();
    List<Serie> findByGenre(Category category);
    @Query("SELECT s FROM Serie s WHERE s.seasons <= :inSeasons AND s.rating >= :inRating")
    List<Serie> seriesBySeasonAndRating(int inSeasons, Double inRating);
    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE e.title ILIKE %:nameEpisode%")
    List<Episode> episodeByname(String nameEpisode);
    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE s = :serie ORDER BY e.rating DESC LIMIT 5")
    List<Episode> top5Episodes(Serie serie);
    @Query("SELECT s FROM Serie s JOIN s.episodes e GROUP BY s ORDER BY MAX(e.released) DESC LIMIT 10")
    List<Serie> recentReleases();
    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE s.id = :id AND e.season = :season")
    List<Episode> getSeasonsByNumber(Long id, Long season);
}
