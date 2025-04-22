package com.sistemaeducativo.asignaturas.repository;

import com.sistemaeducativo.asignaturas.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
