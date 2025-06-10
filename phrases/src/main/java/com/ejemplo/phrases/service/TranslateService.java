package com.ejemplo.phrases.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@Service
public class TranslateService {

    private final WebClient webClient;

    public TranslateService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:5000")
                        .defaultHeader("Content-Type", "application/json")
                        .build();
    }

    public Mono<String> translate(String text) {
        return webClient.post()
                .uri("/translate")
                .bodyValue(Map.of(
                    "q", text,
                    "source", "en",
                    "target", "es",
                    "format", "text"
                ))
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                          clientResponse -> clientResponse.bodyToMono(String.class)
                                                          .flatMap(errorBody -> Mono.error(new RuntimeException("Error en la solicitud: " + errorBody))))
                .bodyToMono(Map.class)
                .map(response -> (String) response.get("translatedText"));
    }
}
