package ext.domain.screenmatch.repository;

import ext.domain.screenmatch.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import ext.domain.screenmatch.model.Serie;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTitleContainsIgnoreCase(String serieTitle);
    List<Serie> findTop5ByOrderByRatingDesc();
    List<Serie> findByGenre(Category category);
}
