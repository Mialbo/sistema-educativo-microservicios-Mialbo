package com.sistemaeducativo.matriculas_servicio.modelo;

import jakarta.persistence.*;
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

    private Long usuarioId;

    private Long asignaturaId;

    private LocalDate fechaMatricula;
    @PrePersist
    public void prePersist() {
        this.fechaMatricula = LocalDate.now();
    }
}
