package com.yaesta.integration.tramaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.integration.tramaco.dto.GuideBeanDTO;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.service.TramacoService;

@RestController
@RequestMapping(value = "/tramacoIntegrationTest")
public class TramacoIntegrationTestController {

	@Autowired
	TramacoService tramacoService;
	
	@RequestMapping(value = "/testPDF/", method = RequestMethod.GET)
	public ResponseEntity<GuideDTO> testPDF() {
		GuideDTO guideInfo = new GuideDTO();
		Guide guide = new Guide();
		guide.setVitexDispatcherId("77%031002000386304");
		//guide.setVitexDispatcherId("72%031002000386299");
		guide.setOrderVitexId("655503371336-01");
		GuideBeanDTO gbd = new GuideBeanDTO();
		gbd.setGuide(guide);
		guideInfo.getGuideBeanList().add(gbd);
		
		GuideDTO response=tramacoService.generateGuidesPDF(guideInfo);
		
		return new ResponseEntity<GuideDTO>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/testTracking/", method = RequestMethod.GET)
	public ResponseEntity<GuideDTO> testTracking() {
		GuideDTO guideInfo = new GuideDTO();
		Guide guide = new Guide();
	
		guide.setOrderVitexId("648410909096-01");
		guide.setVitexDispatcherId("031002000429741");
		GuideBeanDTO gbd = new GuideBeanDTO();
		gbd.setGuide(guide);
		gbd.setGuideDeliveryId("031002000429741");
		guideInfo.getGuideBeanList().add(gbd);
		guideInfo.setGuideBean(gbd);
		
		GuideDTO response=tramacoService.trackingService(guideInfo);
		
		
		return new ResponseEntity<GuideDTO>(response,HttpStatus.OK);
	}
}
