package com.zonarefri.controller;

import com.zonarefri.dto.UsuarioRegistroDTO;
import com.zonarefri.dto.UsuarioResponseDTO;
import com.zonarefri.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponseDTO> registrar(@RequestBody UsuarioRegistroDTO registroDTO) {
        UsuarioResponseDTO usuarioCreado = usuarioService.registrar(registroDTO);
        return ResponseEntity.ok(usuarioCreado);
    }
}

