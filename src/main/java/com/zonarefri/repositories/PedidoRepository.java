package com.zonarefri.repositories;

import com.zonarefri.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para la gestión de la cabecera de los pedidos.
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    // Busca los pedidos realizados por un usuario específico
    List<Pedido> findByUsuarioId(Integer usuarioId);
}