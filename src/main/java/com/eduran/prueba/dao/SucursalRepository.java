package com.eduran.prueba.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduran.prueba.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>  {
	List<Sucursal> findByFranquiciaId(Long franquiciaId);
}
