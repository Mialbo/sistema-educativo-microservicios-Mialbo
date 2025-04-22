package com.sistemaeducativo.auth_service.controller;

import com.sistemaeducativo.auth_service.dto.AuthRequest;
import com.sistemaeducativo.auth_service.dto.AuthResponse;
import com.sistemaeducativo.auth_service.model.Usuario;
import com.sistemaeducativo.auth_service.service.UsuarioService;
import com.sistemaeducativo.auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        Optional<Usuario> usuario = usuarioService.buscarPorEmail(authRequest.getEmail());

        if (usuario.isEmpty() || !usuario.get().getPassword().equals(authRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        String token = jwtUtil.generarToken(usuario.get().getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest authRequest) {
        Optional<Usuario> usuarioExistente = usuarioService.buscarPorEmail(authRequest.getEmail());

        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setEmail(authRequest.getEmail());
        nuevoUsuario.setPassword(authRequest.getPassword()); // Recomendación: encriptar con BCrypt
        nuevoUsuario.setNombre("Nuevo Usuario"); // Puedes adaptar esto si agregas campo nombre a AuthRequest

        usuarioService.guardarUsuario(nuevoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
    }
}
