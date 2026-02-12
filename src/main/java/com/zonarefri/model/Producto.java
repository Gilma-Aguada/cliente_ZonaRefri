package com.zonarefri.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.AccessLevel;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representa un producto en el catálogo de ZonaRefri con detalles técnicos e imágenes.
 */
@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(columnDefinition = "TEXT") // TEXT permite descripciones mucho más largas
    private String descripcion;
    
    @Column(precision = 38, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer stock;
    
    /**
     * URL o ruta de la imagen. 
     * Puede ser una ruta local (ej: /images/heladera1.jpg) o una URL externa.
     */
    @Column(name = "imagen_url", length = 500) 
    private String imagenUrl;
    
    /**
     * Campo Especificaciones Técnicas.
     * Usamos TEXT para cargar listas largas de datos (ej: Frigorías, Medidas, Eficiencia).
     */
    @Column(name = "especificaciones_tecnicas", columnDefinition = "TEXT")
    private String especificacionesTecnicas;
    
    @Column(nullable = false)
    private String categoria;
    
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        // Seguridad: Si no hay stock al crear, ponemos 0
        if (this.stock == null) {
            this.stock = 0;
        }
    }
}