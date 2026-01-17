
package com.zonarefri.service;

import com.zonarefri.model.Envio;
import com.zonarefri.repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    public Optional<Envio> rastrear(String tracking) {
        return envioRepository.findByTrackingNumber(tracking);
    }

    public Envio crearEnvio(Envio envio) {
        return envioRepository.save(envio);
    }
}