package com.sistemaeducativo.matriculas_servicio.controlador;

import com.sistemaeducativo.matriculas_servicio.dto.DetalleMatriculaDto;
import com.sistemaeducativo.matriculas_servicio.modelo.Matricula;
import com.sistemaeducativo.matriculas_servicio.servicio.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<Matricula> crearMatricula(@RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.crearMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> obtenerMatriculas() {
        return ResponseEntity.ok(matriculaService.obtenerMatriculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleMatriculaDto> obtenerDetalle(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.obtenerDetalleMatricula(id));
    }
}
