package com.zonarefri.controller;

import com.zonarefri.model.Pago;
import com.zonarefri.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Buscar un pago por el ID de Mercado Pago
    @GetMapping("/{mpId}")
    public Optional<Pago> buscarPago(@PathVariable String mpId) {
        return pagoService.buscarPorIdMercadoPago(mpId);
    }
}