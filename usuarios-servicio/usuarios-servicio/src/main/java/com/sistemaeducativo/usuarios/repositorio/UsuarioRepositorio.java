package com.sistemaeducativo.usuarios.repositorio;

import com.sistemaeducativo.usuarios.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    // Métodos personalizados si los necesitas más adelante
}
