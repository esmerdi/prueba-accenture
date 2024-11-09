package com.eduran.prueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduran.prueba.dao.SucursalRepository;
import com.eduran.prueba.model.Franquicia;
import com.eduran.prueba.model.Sucursal;

@Service
public class SucursalServiceImpl {
	
	@Autowired
	private SucursalRepository sucursalRepository;

	public Sucursal crearSucursal(Sucursal sucursal) {
		return sucursalRepository.save(sucursal);
	}
	
	public Sucursal actualizarNombreSucursal(Long sucursalId, String nuevoNombre) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        sucursal.setNombre(nuevoNombre);
        return sucursalRepository.save(sucursal);
    }

}
