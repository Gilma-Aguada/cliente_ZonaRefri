package com.zonarefri.controller;

import com.zonarefri.model.Producto;
import com.zonarefri.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:3000") // Permite solicitudes desde el frontend en React (puerto 3000)
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.listarTodos();
    }

    @GetMapping("/categoria/{nombre}")
    public List<Producto> obtenerPorCategoria(@PathVariable String nombre) {
        return productoService.buscarPorCategoria(nombre);
    }
}
