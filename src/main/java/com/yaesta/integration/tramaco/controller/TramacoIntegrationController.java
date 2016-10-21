package com.yaesta.integration.tramaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.integration.tramaco.dto.GuideBeanDTO;
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
	
	@RequestMapping(value = "/trackingGuide/{guideNumber}", method = RequestMethod.GET)
	public ResponseEntity<GuideDTO> trackingGuide(@PathVariable("guideNumber") String guideNumber) {
		GuideDTO guideInfo = new GuideDTO();
		Guide guide = new Guide();
	
		guide.setOrderVitexId(guideNumber);
		guide.setVitexDispatcherId(guideNumber);
		GuideBeanDTO gbd = new GuideBeanDTO();
		gbd.setGuide(guide);
		gbd.setGuideDeliveryId(guideNumber);
		guideInfo.getGuideBeanList().add(gbd);
		guideInfo.setGuideBean(gbd);
		
		
		
		GuideDTO response=tramacoService.trackingService(guideInfo);
		
		
		return new ResponseEntity<GuideDTO>(response,HttpStatus.OK);
	}
	
	
}
