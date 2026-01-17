package com.zonarefri.repositories;

import com.zonarefri.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para la gestión de transacciones de pago.
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    
    /**
     * Permite recuperar un pago utilizando el identificador externo de la pasarela.
     * @param mercadoPagoId Identificador devuelto por Mercado Pago.
     * @return Un Optional con el pago si existe.
     */
    Optional<Pago> findByMercadoPagoId(String mercadoPagoId);
}
