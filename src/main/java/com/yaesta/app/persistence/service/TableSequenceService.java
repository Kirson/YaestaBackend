package com.yaesta.app.persistence.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yaesta.app.persistence.entity.TableSequence;
import com.yaesta.app.persistence.repository.TableSequenceRepository;
import com.yaesta.app.persistence.vo.TableSequenceResponseVO;

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
	
	
	
	public List<TableSequence> getAll(){
		return tableSequenceRepository.findAll();
	}
	
	@Transactional
	public TableSequence save(TableSequence tableSequence){
		TableSequence response = tableSequenceRepository.saveAndFlush(tableSequence);
		
		return response;
	}
	
	
	public TableSequenceResponseVO validateMaxValue(String seqName, Long marginValue){
		TableSequenceResponseVO response = new TableSequenceResponseVO();
		
		TableSequence ts = tableSequenceRepository.getOne(seqName);
		
		if(ts!=null){
			response.setTableSequence(ts);
			if(ts.getSeqMaxValue()!=null){
				Long margin = ts.getSeqMaxValue() - ts.getSeqNextValue();
				
				if(margin<marginValue){
					response.setInsideLimit(Boolean.FALSE);
				}else{
					response.setInsideLimit(Boolean.TRUE);
				}
				response.setDiference(margin);
			}
		}
		
		return response;
	}
}
