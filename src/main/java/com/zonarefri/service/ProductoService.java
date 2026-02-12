package com.zonarefri.service;

import com.zonarefri.model.Producto;
import com.zonarefri.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio para gestionar la lógica de negocio de los productos.
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Obtiene todos los productos del catálogo.
     */
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    /**
     * Busca productos por una categoría específica.
     */
    public List<Producto> buscarPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    /**
     * Busca un producto por su ID.
     */
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    /**
     * Reduce el stock de un producto tras una compra.
     * La anotación @Transactional asegura que si algo falla, no se guarde el cambio.
     */
    @Transactional
    public void reducirStock(Integer productoId, Integer cantidad) {
        Producto producto = buscarPorId(productoId);
        
        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre() + 
                                       ". Disponible: " + producto.getStock());
        }
        
        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);
    }
}