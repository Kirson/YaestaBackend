package com.yaesta.app.persistence.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.GuideProcess;
import com.yaesta.app.persistence.service.GuideProcessService;

@RestController
@RequestMapping(value = "/guideProcess")
public class GuideProcessController implements Serializable{

	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -2190177424990783161L;
	
	@Autowired
	GuideProcessService guideProcessService;
	
	@RequestMapping(value = "/getGuideProcessNoCloseList", method = RequestMethod.GET)
	public ResponseEntity<List<GuideProcess>> getGuideProcessNoCloseList(){
		
		guideProcessService.doProcessDate();
		
		List<GuideProcess> found = guideProcessService.findByClosedDate(Boolean.FALSE);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideProcess>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideProcess>>(new ArrayList<GuideProcess>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getGuideProcessCloseList", method = RequestMethod.GET)
	public ResponseEntity<List<GuideProcess>> getGuideProcessCloseList(){
		List<GuideProcess> found = guideProcessService.findByClosedDate(Boolean.FALSE);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideProcess>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideProcess>>(new ArrayList<GuideProcess>(),HttpStatus.OK);
		}
	}
}
