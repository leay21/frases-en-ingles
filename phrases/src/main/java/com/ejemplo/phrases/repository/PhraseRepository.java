package com.ejemplo.phrases.repository;
import com.ejemplo.phrases.model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    // Para agregar métodos personalizados mas adelante
}
