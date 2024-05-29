package ext.domain.screenmatch.controller;

import ext.domain.screenmatch.dto.EpisodeDTO;
import ext.domain.screenmatch.dto.SerieDTO;
import ext.domain.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService serieService = new SerieService();

    @GetMapping()
    public List<SerieDTO> getSeries(){
        return serieService.getSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> getTop5(){
        return serieService.getTop5();
    }

    @GetMapping("/lanzamientos")
    public List<SerieDTO> getRecentReleases(){
        return serieService.getRecentReleases();
    }

    @GetMapping("/{id}")
    public SerieDTO getById(@PathVariable Long id){
        return serieService.getById(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodeDTO> getSeasons(@PathVariable Long id){
        return serieService.getSeasons(id);
    }

    @GetMapping("/{id}/temporadas/{season}")
    public List<EpisodeDTO> getSeasonsByNumber(@PathVariable Long id, @PathVariable Long season){
        return serieService.getSeasonsByNumber(id, season);
    }

    @GetMapping("/categoria/{genre}")
    public List<SerieDTO> getSeriesByCategory(@PathVariable String genre){
        return serieService.getSeriesByCategory(genre);
    }
}
