package com.zonarefri.dto;

import lombok.Data;
import lombok.Builder;
import java.time.LocalDateTime;

@Data
@Builder
public class UsuarioResponseDTO {
    private Integer id;
    private String nombre;
    private String email;
    private String rol;
    private LocalDateTime fechaRegistro;
    // ¡NO incluye password! (esto es buena práctica siempre)
}
