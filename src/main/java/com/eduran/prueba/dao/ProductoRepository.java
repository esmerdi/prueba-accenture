package com.eduran.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eduran.prueba.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
}
