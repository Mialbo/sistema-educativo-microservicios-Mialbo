package com.sistemaeducativo.matriculas_servicio.cliente;

import com.sistemaeducativo.matriculas_servicio.dto.UsuarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-servicio")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioDto obtenerUsuarioPorId(@PathVariable("id") Long id);
}
