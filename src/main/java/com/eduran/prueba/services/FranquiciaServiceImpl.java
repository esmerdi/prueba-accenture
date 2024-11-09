package com.eduran.prueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduran.prueba.dao.FranquiciaRepository;
import com.eduran.prueba.dao.SucursalRepository;
import com.eduran.prueba.model.Franquicia;
import com.eduran.prueba.model.Sucursal;

@Service
public class FranquiciaServiceImpl {
	
	@Autowired
	private FranquiciaRepository franquiciaRepository;
	
	@Autowired
    private SucursalRepository sucursalRepository;
	
	public Franquicia crearFranquicia(Franquicia franquicia) {
		return franquiciaRepository.save(franquicia);
	}
	
	public Sucursal agregarSucursalAFranquicia(Sucursal sucursal) {
        Franquicia franquicia = franquiciaRepository.findById(sucursal.getFranquicia().getId())
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        sucursal.setFranquicia(franquicia);

        return sucursalRepository.save(sucursal);
    }
	
	public Franquicia actualizarNombreFranquicia(Long franquiciaId, String nuevoNombre) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        franquicia.setNombre(nuevoNombre);
        return franquiciaRepository.save(franquicia);
    }

}
