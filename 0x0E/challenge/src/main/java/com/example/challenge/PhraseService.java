package com.example.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhraseService {
    @Autowired
    private PhraseRepository phraseRepository;
    public PhraseDTO getPhrase(){
        Phrase phrase =  phraseRepository.getPhrase();
        return new PhraseDTO(phrase.getTitle(), phrase.getPhrase(), phrase.getCharacter(), phrase.getPoster());
    }
}
