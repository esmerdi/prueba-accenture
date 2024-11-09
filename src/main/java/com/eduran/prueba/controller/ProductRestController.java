package com.eduran.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eduran.prueba.model.Producto;
import com.eduran.prueba.services.ProductoServiceImpl;

@RequestMapping("/api/v1")
@RestController
public class ProductRestController {

	@Autowired
	private ProductoServiceImpl productoService;

	@DeleteMapping("/productos/{productoId}/sucursales/{sucursalId}")
	public ResponseEntity<Producto> eliminarProductoDeSucursal(@PathVariable Long productoId,
			@PathVariable Long sucursalId) {

		Producto productoEliminado = productoService.eliminarProductoDeSucursal(productoId, sucursalId);
		return ResponseEntity.ok(productoEliminado);
	}

	@PutMapping("/productos/{productoId}/actualizar_stock")
	public ResponseEntity<Producto> actualizarStock(@PathVariable Long productoId, @RequestBody Producto producto) {

		Producto productoActualizado = productoService.actualizarStock(productoId, producto);
		return ResponseEntity.ok(productoActualizado); 
	}
	
	@PutMapping("/productos/actualizar/{productoId}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        Producto productoActualizado = productoService.actualizarProducto(productoId, producto);
        return ResponseEntity.ok(productoActualizado);
    }

}
