package com.eduran.prueba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduran.prueba.dao.ProductoRepository;
import com.eduran.prueba.dao.SucursalRepository;
import com.eduran.prueba.model.Producto;
import com.eduran.prueba.model.Sucursal;

@Service
public class ProductoServiceImpl {

	@Autowired
	private SucursalRepository sucursalRepository;
	
	@Autowired
	private ProductoRepository productoRepository;

	public Producto agregarProductoASucursal(Producto producto) {
		Sucursal sucursal = sucursalRepository.findById(producto.getSucursal().getId())
				.orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

		producto.setSucursal(sucursal);
		producto.setStock(producto.getStock());
		producto.setNombre(producto.getNombre());

		return productoRepository.save(producto);
	}
	
	public Producto eliminarProductoDeSucursal(Long productoId, Long sucursalId) {
        if (!sucursalRepository.existsById(sucursalId)) {
            throw new RuntimeException("Sucursal no encontrada");
        }
        
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (!producto.getSucursal().getId().equals(sucursalId)) {
            throw new RuntimeException("El producto no pertenece a la sucursal indicada");
        }

        productoRepository.delete(producto);
        return producto;
    }
	
	public Producto actualizarStock(Long productoId, Producto productoStock) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setStock(productoStock.getStock());  
        return productoRepository.save(producto); 
    }
	
	public List<Producto> obtenerProductosMayorStockPorFranquicia(Long franquiciaId) {
        List<Sucursal> sucursales = sucursalRepository.findByFranquiciaId(franquiciaId);

        List<Producto> productosConMayorStock = new ArrayList<>();
        
        // Iterar sobre las sucursales y obtener el producto con mayor stock
        for (Sucursal sucursal : sucursales) {
            Producto productoMayorStock = productoRepository
                    .findTopBySucursalIdOrderByStockDesc(sucursal.getId())
                    .orElse(null);

            if (productoMayorStock != null) {
                productosConMayorStock.add(productoMayorStock);
            }
        }

        return productosConMayorStock;
    }

}
