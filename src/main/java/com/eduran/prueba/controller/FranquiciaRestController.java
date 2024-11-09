package com.eduran.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eduran.prueba.model.Franquicia;
import com.eduran.prueba.model.Producto;
import com.eduran.prueba.model.Sucursal;
import com.eduran.prueba.services.FranquiciaServiceImpl;
import com.eduran.prueba.services.ProductoServiceImpl;

@RequestMapping("/api/v1")
@RestController
public class FranquiciaRestController {
	
	@Autowired
	private FranquiciaServiceImpl franquiciaService;
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@PostMapping("/franquicias")
	public ResponseEntity<Franquicia> crearFranquicia(@RequestBody Franquicia franquicia){
		Franquicia nuevaFranquicia = franquiciaService.crearFranquicia(franquicia);
		
		return new ResponseEntity<>(nuevaFranquicia, HttpStatus.CREATED);
	}
	
	@PostMapping("/franquicias/agregar_sucursal")
    public ResponseEntity<Sucursal> agregarSucursal(@RequestBody Sucursal sucursal) {
        Sucursal nuevaSucursal = franquiciaService.agregarSucursalAFranquicia(sucursal);
        
        return ResponseEntity.status(201).body(nuevaSucursal);
    }
	
	@GetMapping("/franquicias/{franquiciaId}/productos_mayor_stock")
    public ResponseEntity<List<Producto>> obtenerProductosMayorStockPorFranquicia(
            @PathVariable Long franquiciaId) {
        
        List<Producto> productos = productoService.obtenerProductosMayorStockPorFranquicia(franquiciaId);
        
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(productos);
    }
	
	@PutMapping("/franquicias/actualizar/{franquiciaId}")
    public ResponseEntity<Franquicia> actualizarNombreFranquicia(@PathVariable Long franquiciaId, @RequestBody Franquicia franquicia) {
        Franquicia franquiciaActualizada = franquiciaService.actualizarNombreFranquicia(franquiciaId, franquicia.getNombre());
        return ResponseEntity.ok(franquiciaActualizada);
    }
	
}
