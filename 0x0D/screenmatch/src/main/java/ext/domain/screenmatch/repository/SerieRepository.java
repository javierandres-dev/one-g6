package ext.domain.screenmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ext.domain.screenmatch.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
