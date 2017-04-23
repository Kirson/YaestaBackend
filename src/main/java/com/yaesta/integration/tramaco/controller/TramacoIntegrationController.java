package com.yaesta.integration.tramaco.controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.integration.tramaco.dto.GuideBeanDTO;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.service.TramacoService;


@Controller
@Api(name = "TRAMACO API", 
     description = "Methods for managing TRAMACO INTEGRATION", 
     group = "Integration",
     visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "0.1", until = "1.0")
@ApiAuthNone
@RestController
@RequestMapping(value = "/tramacoIntegration")
public class TramacoIntegrationController {

	@Autowired
	TramacoService tramacoService;
	
	@ApiMethod(description="AUTH Tramaco Service",
			   path="/tramacoIntegration/authService",
			   produces = { MediaType.APPLICATION_JSON_VALUE }, 
			   consumes = { MediaType.APPLICATION_JSON_VALUE })
	@RequestMapping(value = "/authService/", method = RequestMethod.GET)
	public @ApiResponseObject ResponseEntity<String> authService() {
		String result = tramacoService.authService().getResponse();
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@ApiMethod(description="Tramaco Tracking Service",
			   path="/tramacoIntegration/trackingGuide/{guideNumber}",
			   produces = { MediaType.APPLICATION_JSON_VALUE }, 
			   consumes = { MediaType.APPLICATION_JSON_VALUE })
	@RequestMapping(value = "/trackingGuide/{guideNumber}", method = RequestMethod.GET)
	public ResponseEntity<GuideDTO> trackingGuide(@ApiPathParam(description = "The guide number") @PathVariable("guideNumber") String guideNumber) {
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
