package com.zonarefri.service;

import com.zonarefri.dto.UsuarioRegistroDTO;
import com.zonarefri.dto.UsuarioResponseDTO;
import com.zonarefri.model.Usuario;
import com.zonarefri.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    public UsuarioResponseDTO registrar(UsuarioRegistroDTO registroDTO) {
        // 1. Validar que el email no exista
        if (usuarioRepository.findByEmail(registroDTO.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }
        
        // 2. Crear el usuario (sin cifrar por ahora, lo harás después con tu colaborador)
        Usuario usuario = Usuario.builder()
            .nombre(registroDTO.getNombre())
            .email(registroDTO.getEmail())
            .password(registroDTO.getPassword()) // Por ahora sin cifrar
            .rol(registroDTO.getRol() != null ? registroDTO.getRol() : "USER")
            .build();
        
        // 3. Guardar en la base de datos
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        
        // 4. Devolver un DTO SIN el password (buena práctica)
        return UsuarioResponseDTO.builder()
            .id(usuarioGuardado.getId())
            .nombre(usuarioGuardado.getNombre())
            .email(usuarioGuardado.getEmail())
            .rol(usuarioGuardado.getRol())
            .fechaRegistro(usuarioGuardado.getFechaRegistro())
            .build();
    }
}