package com.sistemaeducativo.matriculas_servicio.repositorio;

import com.sistemaeducativo.matriculas_servicio.modelo.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByUsuarioId(Long usuarioId);
}
