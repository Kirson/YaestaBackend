package com.yaesta.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Proveedor;

public interface ProveedorRepository  extends JpaRepository<Proveedor, String>{
	
	public Proveedor findByCodigo(Long codigo);

}
