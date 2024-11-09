package com.eduran.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eduran.prueba.model.Producto;
import com.eduran.prueba.services.ProductoServiceImpl;

@RequestMapping("/api/v1")
@RestController
public class SucursalRestController {
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@PostMapping("/sucursales/agregar_producto")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.agregarProductoASucursal(producto);
        
        return ResponseEntity.status(201).body(nuevoProducto);
    }
}
