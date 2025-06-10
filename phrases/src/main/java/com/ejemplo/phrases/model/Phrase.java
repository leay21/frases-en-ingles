package com.ejemplo.phrases.model;
import jakarta.persistence.*;

@Entity
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalText;
    private String translatedText;

    public Phrase() {
    }
    public Phrase(String originalText, String translatedText) {
        this.originalText = originalText;
        this.translatedText = translatedText;
    }

    public Long getId(){
         return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalText() {
        return originalText;
    }
    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getTranslatedText() {
        return translatedText;
    }
    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
    
}