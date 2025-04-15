package com.sistemaeducativo.matriculas_servicio.dto;

import com.sistemaeducativo.matriculas_servicio.modelo.Matricula;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleMatriculaDto {
    private Matricula matricula;
    private UsuarioDto usuario;
    private AsignaturaDto asignatura;
}
