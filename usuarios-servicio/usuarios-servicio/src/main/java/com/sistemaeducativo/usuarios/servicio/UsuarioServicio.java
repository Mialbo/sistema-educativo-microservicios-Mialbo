package com.sistemaeducativo.usuarios.servicio;

import com.sistemaeducativo.usuarios.modelo.Usuario;
import com.sistemaeducativo.usuarios.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;

    public List<Usuario> obtenerTodos() {
        return repositorio.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
