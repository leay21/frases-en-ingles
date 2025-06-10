package com.ejemplo.phrases.controller;

import com.ejemplo.phrases.model.Phrase;
import com.ejemplo.phrases.service.PhraseService;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/phrases")
public class PhraseController {

    @Autowired
    private PhraseService phraseService;

    @PostMapping
    public Mono<Phrase> createPhrase(@RequestBody Map<String, String> request) {
        String originalText = request.get("originalText");
        return phraseService.addPhrase(originalText);
    }

    @GetMapping
    public List<Phrase> getAllPhrases() {
        return phraseService.getAllPhrases();
    }
}
