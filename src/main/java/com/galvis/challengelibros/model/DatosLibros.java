package com.galvis.challengelibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Autor> autor,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Double numeroDeDescargas) {
    @Override
    public String toString() {
        return "Datos Libro{" +
                "titulo='" + titulo + '\'' +
                autor +
                ", idiomas=" + idiomas +
                ", numeroDeDescargas=" + numeroDeDescargas +
                '}';
    }
}
