package com.zonarefri.repositories;

import com.zonarefri.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para la entidad Usuario.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Método personalizado para buscar por email (importante para seguridad) 
    Optional<Usuario> findByEmail(String email);
}