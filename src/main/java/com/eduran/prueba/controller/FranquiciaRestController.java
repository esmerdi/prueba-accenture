package com.eduran.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eduran.prueba.model.Franquicia;
import com.eduran.prueba.model.Sucursal;
import com.eduran.prueba.services.FranquiciaServiceImpl;

@RequestMapping("/api/v1")
@RestController
public class FranquiciaRestController {
	
	@Autowired
	private FranquiciaServiceImpl franquiciaService;
	
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
	
}
