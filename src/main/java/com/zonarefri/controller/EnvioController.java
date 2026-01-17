package com.zonarefri.controller;

import com.zonarefri.model.Envio;
import com.zonarefri.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    // Rastrear un envío por su código de seguimiento
    @GetMapping("/rastreo/{tracking}")
    public ResponseEntity<Envio> rastrearPedido(@PathVariable String tracking) {
        return envioService.rastrear(tracking)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}