package com.zonarefri.service;

import com.zonarefri.model.Pago;
import com.zonarefri.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Optional<Pago> buscarPorIdMercadoPago(String mpId) {
        return pagoRepository.findByMercadoPagoId(mpId); 
        }
}