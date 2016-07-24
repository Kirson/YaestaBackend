package com.yaesta.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.TableSequence;

public interface TableSequenceRepository  extends JpaRepository<TableSequence, String>{

}
