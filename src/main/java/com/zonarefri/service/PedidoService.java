package com.zonarefri.service;

import com.zonarefri.model.*;
import com.zonarefri.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
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
        BigDecimal totalPedido = BigDecimal.ZERO;

        // 1. Guardar cabecera inicial para tener un ID
        Pedido nuevoPedido = pedidoRepository.save(pedido);

        // 2. Procesar cada detalle
        for (PedidoDetalle detalle : detalles) {
            Producto producto = productoRepository.findById(detalle.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + detalle.getProducto().getId()));

            // --- VALIDACIÓN CRÍTICA: ¿Hay stock? ---
            if (producto.getStock() < detalle.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombre() + 
                                           " (Disponible: " + producto.getStock() + ")");
            }

            // 3. Descontar stock
            producto.setStock(producto.getStock() - detalle.getCantidad());
            productoRepository.save(producto);

            // 4. Configurar y guardar el detalle
            detalle.setPedido(nuevoPedido);
            detalle.setPrecioUnitario(producto.getPrecio());
            detalleRepository.save(detalle);

            // 5. Sumar al total del pedido
            BigDecimal subtotal = producto.getPrecio().multiply(new BigDecimal(detalle.getCantidad()));
            totalPedido = totalPedido.add(subtotal);
        }

        // 6. Actualizar el total en la cabecera y guardar de nuevo
        nuevoPedido.setTotal(totalPedido);
        return pedidoRepository.save(nuevoPedido);
    }
}