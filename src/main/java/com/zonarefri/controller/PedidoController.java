package com.zonarefri.controller;

import com.zonarefri.dto.PedidoCompraRequest; 
import com.zonarefri.model.Pedido;
import com.zonarefri.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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