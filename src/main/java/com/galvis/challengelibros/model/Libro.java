package com.galvis.challengelibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private List<String> idiomas;
    private Double numeroDeDescargas;
    @Transient
    private List<Autor> autores;

    public Libro(){}

    public Libro(DatosLibros datosLibros){
        this.titulo = datosLibros.titulo();
//        this.autor = datosLibros.autor();
        this.idiomas = datosLibros.idiomas();
        this.numeroDeDescargas = datosLibros.numeroDeDescargas();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

//    public List<DatosAutor> getAutor() {
//        return autor;
//    }
//
//    public void setAutor(List<DatosAutor> autor) {
//        this.autor = autor;
//    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }


}
