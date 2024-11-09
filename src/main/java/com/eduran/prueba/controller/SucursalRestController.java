package com.eduran.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eduran.prueba.model.Franquicia;
import com.eduran.prueba.model.Producto;
import com.eduran.prueba.model.Sucursal;
import com.eduran.prueba.services.FranquiciaServiceImpl;
import com.eduran.prueba.services.ProductoServiceImpl;
import com.eduran.prueba.services.SucursalServiceImpl;

@RequestMapping("/api/v1")
@RestController
public class SucursalRestController {
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@Autowired
	private SucursalServiceImpl sucursalService;
	
	@PostMapping("/sucursales/agregar_producto")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.agregarProductoASucursal(producto);
        
        return ResponseEntity.status(201).body(nuevoProducto);
    }
	
	@PutMapping("/sucursales/actualizar/{sucursalId}")
    public ResponseEntity<Sucursal> actualizarNombreSucursal(@PathVariable Long sucursalId, @RequestBody Sucursal sucursal) {
        Sucursal sucursalActualizada = sucursalService.actualizarNombreSucursal(sucursalId, sucursal.getNombre());
        return ResponseEntity.ok(sucursalActualizada);
    }
}
