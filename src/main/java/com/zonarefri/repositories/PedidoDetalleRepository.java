package com.zonarefri.repositories;

import com.zonarefri.model.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para la gestión de los items o detalles de cada pedido.
 */
@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Integer> {
    // Recupera todos los productos asociados a un ID de pedido
    List<PedidoDetalle> findByPedidoId(Integer pedidoId);
}