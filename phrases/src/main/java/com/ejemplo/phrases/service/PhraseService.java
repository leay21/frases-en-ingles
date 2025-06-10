package com.ejemplo.phrases.service;
import com.ejemplo.phrases.model.Phrase;
import com.ejemplo.phrases.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PhraseService {
    
    @Autowired
    private PhraseRepository phraseRepository;

    @Autowired
    private TranslateService translateService;

    private final RestTemplate restTemplate = new RestTemplate();

    //Traducción
    public Mono<Phrase> addPhrase(String originalText) {
        return translateService.translate(originalText)
                .map(translatedText -> {
                    Phrase phrase = new Phrase();
                    phrase.setOriginalText(originalText);
                    phrase.setTranslatedText(translatedText);
                    return phraseRepository.save(phrase);
                });
    }

    public List<Phrase> getAllPhrases() {
        return phraseRepository.findAll();
    }
}
