package com.example.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhraseController {
    @Autowired
    PhraseService phraseService;

    @GetMapping("/series/phrases")
    public PhraseDTO getPhrase(){
        return phraseService.getPhrase();
    }
}
