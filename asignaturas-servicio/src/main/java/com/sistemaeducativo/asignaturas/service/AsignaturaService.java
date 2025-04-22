package com.sistemaeducativo.asignaturas.service;

import com.sistemaeducativo.asignaturas.model.Asignatura;
import com.sistemaeducativo.asignaturas.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repository;

    public AsignaturaService(AsignaturaRepository repository) {
        this.repository = repository;
    }

    public List<Asignatura> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Asignatura> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Asignatura guardar(Asignatura asignatura) {
        return repository.save(asignatura);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
