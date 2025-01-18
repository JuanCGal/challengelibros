package com.galvis.challengelibros.repository;

import com.galvis.challengelibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
