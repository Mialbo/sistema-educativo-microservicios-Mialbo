package com.sistemaeducativo.matriculas_servicio.cliente;

import com.sistemaeducativo.matriculas_servicio.dto.AsignaturaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio")
public interface AsignaturaClient {

    @GetMapping("/api/asignaturas/{id}")
    AsignaturaDto obtenerAsignaturaPorId(@PathVariable("id") Long id);
}
