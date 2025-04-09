package com.sistemaeducativo.usuarios.controlador;

import com.sistemaeducativo.usuarios.modelo.Usuario;
import com.sistemaeducativo.usuarios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio servicio;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return servicio.guardar(usuario);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuario(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
