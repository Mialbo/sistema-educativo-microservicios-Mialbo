package com.sistemaeducativo.matriculas_servicio.dto;

import com.sistemaeducativo.matriculas_servicio.modelo.Matricula;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleMatriculaDto {
    private Matricula matricula;
    @NotNull(message = "El usuarioID no puede ser nulo")
    private UsuarioDto usuario;
    @NotNull(message = "El asignaturaId no puede ser nulo")
    private AsignaturaDto asignatura;
}
