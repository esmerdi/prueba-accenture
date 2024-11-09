package com.eduran.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduran.prueba.model.Producto;
import com.eduran.prueba.services.ProductoServiceImpl;

@RequestMapping("/api/v1")
@RestController
public class ProductRestController {
	
	@Autowired
    private ProductoServiceImpl productoService;
	
	@DeleteMapping("/productos/{productoId}/sucursales/{sucursalId}")
    public ResponseEntity<Producto> eliminarProductoDeSucursal(@PathVariable Long productoId,  @PathVariable Long sucursalId) {
        
		Producto productoEliminado = productoService.eliminarProductoDeSucursal(productoId, sucursalId);
		return ResponseEntity.ok(productoEliminado);
    }
	
}
