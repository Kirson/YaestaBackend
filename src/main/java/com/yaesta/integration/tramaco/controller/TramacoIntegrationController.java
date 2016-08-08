package com.yaesta.integration.tramaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.service.TramacoService;


@RestController
@RequestMapping(value = "/tramacoIntegration")
public class TramacoIntegrationController {

	@Autowired
	TramacoService tramacoService;
	
	@RequestMapping(value = "/authService/", method = RequestMethod.GET)
	public ResponseEntity<String> authService() {
		String result = tramacoService.authService().getResponse();
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/testPDF/", method = RequestMethod.GET)
	public ResponseEntity<GuideDTO> testPDF() {
		GuideDTO guideInfo = new GuideDTO();
		Guide guide = new Guide();
		guide.setGuideDispatcherId("10%031002000386212");
		guide.setVitexDispatcherId("10%031002000386212");
		guide.setOrderVitexId("650182888103-01");
		guideInfo.setGuide(guide);
		
		GuideDTO response=tramacoService.generateGuiaPDF(guideInfo);
		
		
		return new ResponseEntity<GuideDTO>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/testTracking/", method = RequestMethod.GET)
	public ResponseEntity<GuideDTO> testTracking() {
		GuideDTO guideInfo = new GuideDTO();
		Guide guide = new Guide();
		guide.setGuideDispatcherId("031002000386207");
		guide.setOrderVitexId("648410909096-01");
		guideInfo.setGuide(guide);
		
		GuideDTO response=tramacoService.trackingService(guideInfo);
		
		
		return new ResponseEntity<GuideDTO>(response,HttpStatus.OK);
	}
}
