package com.sistemaeducativo.matriculas_servicio.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignaturaDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private int creditos;
}
