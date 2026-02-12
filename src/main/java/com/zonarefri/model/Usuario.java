package com.zonarefri.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.ToString;
import java.time.LocalDateTime;

/**
 * Entidad que representa a los usuarios del sistema.
 */
@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    @ToString.Exclude
    private String password;

    // Es obligatorio (nullable = false)
    @Column(nullable = false, length = 20)
    private String rol;

    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
        // Si al crear el usuario nos olvidamos de ponerle rol, por defecto será CLIENTE
        if (this.rol == null) {
            this.rol = "CLIENTE";
        }
    }
}