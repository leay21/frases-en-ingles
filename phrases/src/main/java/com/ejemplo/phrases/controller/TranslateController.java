package com.ejemplo.phrases.controller;
import com.ejemplo.phrases.dto.TranslateRequest;
import com.ejemplo.phrases.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/translate")
public class TranslateController {
    
    @Autowired
    private TranslateService translateService;

    @PostMapping
    public Mono<String> translate(@RequestBody TranslateRequest request) {
        return translateService.translate(request.getText());
    }
}
