package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.ClienteBodega;

public interface ClienteBodegaRepository  extends JpaRepository<ClienteBodega, String> {

	List<ClienteBodega> findByNuevo(String nuevo);
}
