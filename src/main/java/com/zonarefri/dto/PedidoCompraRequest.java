package com.zonarefri.dto;

import com.zonarefri.model.Pedido;
import com.zonarefri.model.PedidoDetalle;
import lombok.Data;
import java.util.List;

@Data
public class PedidoCompraRequest {
    private Pedido pedido;
    private List<PedidoDetalle> detalles;
}