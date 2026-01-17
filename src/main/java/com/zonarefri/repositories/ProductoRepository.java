package com.zonarefri.repositories;

import com.zonarefri.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para la entidad Producto.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Permite filtrar por categoría en el frontend [cite: 20]
    List<Producto> findByCategoria(String categoria);
}
