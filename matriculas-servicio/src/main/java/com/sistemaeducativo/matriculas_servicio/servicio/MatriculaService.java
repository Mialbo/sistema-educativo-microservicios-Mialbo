// 📁 servicio/MatriculaService.java
package com.sistemaeducativo.matriculas_servicio.servicio;

import com.sistemaeducativo.matriculas_servicio.dto.*;
import com.sistemaeducativo.matriculas_servicio.modelo.Matricula;
import com.sistemaeducativo.matriculas_servicio.repositorio.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Matricula crearMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> obtenerMatriculas() {
        return matriculaRepository.findAll();
    }

    public DetalleMatriculaDto obtenerDetalleMatricula(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElse(null);

        if (matricula == null) {
            return null; // O lanzar excepción
        }

        UsuarioDto usuario = restTemplate.getForObject(
                "http://localhost:8082/api/usuarios/" + matricula.getUsuarioId(),
                UsuarioDto.class
        );

        AsignaturaDto asignatura = restTemplate.getForObject(
                "http://localhost:8081/api/asignaturas/" + matricula.getAsignaturaId(),
                AsignaturaDto.class
        );

        DetalleMatriculaDto dto = new DetalleMatriculaDto();
        dto.setMatricula(matricula);
        dto.setUsuario(usuario);
        dto.setAsignatura(asignatura);

        return dto;
    }
}
