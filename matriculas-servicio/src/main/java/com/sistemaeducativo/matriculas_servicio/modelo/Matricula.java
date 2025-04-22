package com.sistemaeducativo.matriculas_servicio.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El usuarioId no puede ser nulo")
    private Long usuarioId;
    @NotNull(message = "El asignaturaId no puede ser nulo")
    private Long asignaturaId;

    private LocalDate fechaMatricula;
    @PrePersist
    public void prePersist() {
        this.fechaMatricula = LocalDate.now();
    }
}
