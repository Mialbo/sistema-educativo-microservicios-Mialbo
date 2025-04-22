package com.sistemaeducativo.usuarios.controlador;

import com.sistemaeducativo.usuarios.servicio.AsignaturaClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AsignaturaProxyController {

    private final AsignaturaClientService asignaturaClientService;

    public AsignaturaProxyController(AsignaturaClientService asignaturaClientService) {
        this.asignaturaClientService = asignaturaClientService;
    }

    @GetMapping("/api/usuarios/asignaturas")
    public List<Object> obtenerAsignaturasDesdeAsignaturasServicio() {
        return asignaturaClientService.obtenerAsignaturas();
    }
}
