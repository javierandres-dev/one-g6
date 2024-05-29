package ext.domain.screenmatch.service;

import ext.domain.screenmatch.dto.EpisodeDTO;
import ext.domain.screenmatch.dto.SerieDTO;
import ext.domain.screenmatch.model.Category;
import ext.domain.screenmatch.model.Episode;
import ext.domain.screenmatch.model.Serie;
import ext.domain.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;

    public List<SerieDTO> convertData(List<Serie> series){
        return series.stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitle(), s.getSeasons(), s.getRating(), s.getPoster(), s.getGenre(), s.getActors(), s.getSynopsis()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> getSeries(){
        return convertData(serieRepository.findAll());
    }

    public List<SerieDTO> getTop5() {
        return convertData(serieRepository.findTop5ByOrderByRatingDesc());
    }

    public List<SerieDTO> getRecentReleases(){
        return convertData(serieRepository.recentReleases());
    }

    public SerieDTO getById(Long id){
        Optional<Serie> serie = serieRepository.findById(id);
        if (serie.isPresent()){
            Serie s = serie.get();
            return new SerieDTO(s.getId(), s.getTitle(), s.getSeasons(), s.getRating(), s.getPoster(), s.getGenre(), s.getActors(), s.getSynopsis());
        }
        return null;
    }

    public List<EpisodeDTO> getSeasons(Long id) {
        Optional<Serie> serie = serieRepository.findById(id);
        if (serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodes().stream().map(e -> new EpisodeDTO(e.getSeason(), e.getTitle(), e.getEpisode())).collect(Collectors.toList());
        }
        return null;
    }

    public List<EpisodeDTO> getSeasonsByNumber(Long id, Long season) {
        return serieRepository.getSeasonsByNumber(id, season).stream().map(e -> new EpisodeDTO(e.getSeason(), e.getTitle(), e.getEpisode())).collect(Collectors.toList());
    }

    public List<SerieDTO> getSeriesByCategory(String genre) {
        //Category category = Category.fromSpanish(genre);
        Category category = Category.fromString(genre);
        return convertData(serieRepository.findByGenre(category));
    }
}
