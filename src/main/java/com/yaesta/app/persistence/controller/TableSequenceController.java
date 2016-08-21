package com.yaesta.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.service.TableSequenceService;
import com.yaesta.app.persistence.vo.TableSequenceVO;
import com.yaesta.app.persistence.entity.TableSequence;

@RestController
@RequestMapping(value = "/sequence")
public class TableSequenceController {
    
	@Autowired
	TableSequenceService tableSequenceService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<TableSequence>> getAll(){
		
		List<TableSequence> found = tableSequenceService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<TableSequence>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<TableSequence>>(new ArrayList<TableSequence>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<TableSequence> save(@RequestBody TableSequenceVO tableSequenceVO){
		
		TableSequence response = tableSequenceService.save(tableSequenceVO.getTableSequence());
		
		return new ResponseEntity<TableSequence>(response,HttpStatus.OK);
	}
}
