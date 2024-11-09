package com.eduran.prueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduran.prueba.dao.SucursalRepository;
import com.eduran.prueba.model.Sucursal;

@Service
public class SucursalServiceImpl {
	
	@Autowired
	private SucursalRepository sucursalRepository;

	public Sucursal crearSucursal(Sucursal sucursal) {
		return sucursalRepository.save(sucursal);
	}

}
