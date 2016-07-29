package com.yaesta.app.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.TableSequence;
import com.yaesta.app.persistence.repository.TableSequenceRepository;

@Service
public class TableSequenceService {
	
	@Autowired
	TableSequenceRepository tableSequenceRepository;

	/**
	 * Devolver el siguiente valor
	 * @param seqName
	 * @return
	 */
	public Long getNextValue(String seqName){
		
		System.out.println("Secuencia: "+seqName);
		TableSequence ts = tableSequenceRepository.getOne(seqName);
		
		if(ts!=null){
			
			Long nv = ts.getSeqNextValue();
			
			ts.setSeqNextValue(nv+ts.getIncrement());
			
			tableSequenceRepository.save(ts);
			
			return nv;
			
		}else{
			return null;
		}
		
	}
	
}