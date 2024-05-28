package ext.domain.screenmatch.controller;

import ext.domain.screenmatch.dto.SerieDTO;
import ext.domain.screenmatch.model.Serie;
import ext.domain.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {
    @Autowired
    private SerieRepository serieRepository;

    @GetMapping("/")
    public String getRoot(){
        return "works!";
    }

    @GetMapping("/series")
    /*public String sendMessage(){
        return  "works!";
    }*/
    /*public List<Serie> getSeries(){
        return serieRepository.findAll();
    }*/
    public List<SerieDTO> getSeries(){
        return serieRepository.findAll().stream()
                .map(s -> new SerieDTO(s.getTitle(), s.getSeasons(), s.getRating(), s.getPoster(), s.getGenre(), s.getActors(), s.getSynopsis()))
                .collect(Collectors.toList());
    }
}
