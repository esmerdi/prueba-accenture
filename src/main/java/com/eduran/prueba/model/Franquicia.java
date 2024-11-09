package com.eduran.prueba.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="franquicias")
public class Franquicia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@OneToMany(mappedBy = "franquicia")
	private List<Sucursal> sucursales;
	
	@CreationTimestamp
	private LocalDateTime created_at;
	    
	@UpdateTimestamp
	private LocalDateTime updated_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return nombre;
	}
	
	public void setName(String name) {
		this.nombre = name;
	}
	
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
}
