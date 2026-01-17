package com.zonarefri.service;

import com.zonarefri.model.*;
import com.zonarefri.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoDetalleRepository detalleRepository;
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public Pedido crearPedidoCompleto(Pedido pedido, List<PedidoDetalle> detalles) {
        // 1. Guardar cabecera del pedido
        Pedido nuevoPedido = pedidoRepository.save(pedido);

        // 2. Procesar cada detalle y actualizar stock
        for (PedidoDetalle detalle : detalles) {
            Producto producto = productoRepository.findById(detalle.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            // Descontar stock 
            producto.setStock(producto.getStock() - detalle.getCantidad());
            productoRepository.save(producto);

            // Guardar detalle vinculado al pedido
            detalle.setPedido(nuevoPedido);
            detalle.setPrecioUnitario(producto.getPrecio());
            detalleRepository.save(detalle);
        }
        return nuevoPedido;
    }
}