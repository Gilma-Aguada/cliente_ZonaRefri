package com.zonarefri.controller;

import com.zonarefri.model.Pedido;
import com.zonarefri.model.PedidoDetalle;
import com.zonarefri.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> realizarCompra(@RequestBody PedidoCompraRequest request) {
        Pedido nuevoPedido = pedidoService.crearPedidoCompleto(request.getPedido(), request.getDetalles());
        return ResponseEntity.ok(nuevoPedido);
    }
}

/**
 * Clase auxiliar (DTO) para recibir el pedido y sus detalles juntos en el JSON
 */
class PedidoCompraRequest {
    private Pedido pedido;
    private List<PedidoDetalle> detalles;
    
    // Getters y Setters
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public List<PedidoDetalle> getDetalles() { return detalles; }
    public void setDetalles(List<PedidoDetalle> detalles) { this.detalles = detalles; }
}