package com.yaesta.app.persistence.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiMethod;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.pdf.bean.GuideProcessResultBean;
import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.service.GuideProcessService;
import com.yaesta.app.persistence.service.GuideService;
import com.yaesta.app.persistence.vo.DateRangeVO;
import com.yaesta.app.persistence.vo.GuideBeanVO;
import com.yaesta.app.persistence.vo.GuideDeliveryNotificationVO;
import com.yaesta.app.persistence.vo.GuidePaymentVO;
import com.yaesta.app.persistence.vo.GuideSearchVO;
import com.yaesta.app.persistence.vo.GuideVO;
import com.yaesta.app.persistence.vo.TrackingVO;
import com.yaesta.integration.vitex.json.bean.enums.PaymentEnum;

@Controller
@Api(name = "Guide API", 
     description = "Methods for managing orders", 
     group = "Persistence",
     visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "0.1", until = "1.0")
@ApiAuthNone
@RestController
@RequestMapping(value = "/guide")
public class GuideController implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2760971642899873273L;
	
	@Autowired
	GuideService guideService;
	
	@Autowired
	GuideProcessService guideProcessService;
	

	@ApiMethod(description="Get all guides",
			   path="/guide/getAll",
			   produces = { MediaType.APPLICATION_JSON_VALUE }, 
			   consumes = { MediaType.APPLICATION_JSON_VALUE })
	@RequestMapping(value = "/getAll/", method = RequestMethod.GET)
	public @ApiResponseObject ResponseEntity<List<Guide>> getAll(){
		List<Guide> found = guideService.getAll();
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<Guide>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Guide>>(new ArrayList<Guide>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findByDeliveryName{deliveryName}", method = RequestMethod.GET)
	public ResponseEntity<List<Guide>> findByDeliveryName(@PathVariable("deliveryName") String deliveryName){
		List<Guide> found = guideService.findByDeliveryName(deliveryName);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<Guide>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Guide>>(new ArrayList<Guide>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getAllVO", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> getAllVO(){
		List<GuideVO> found = guideService.getAllVO();
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getGuidesByRangeDateVO/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> getGuidesByRangeDateVO(@PathVariable("startDate") Date startDate,@PathVariable("finishDate") Date finishDate) throws ParseException{
		
		DateRangeVO dateRange = new DateRangeVO();
		
		dateRange.setStartDate(startDate);
		dateRange.setFinishDate(finishDate);
		List<GuideVO> found = guideService.findByOrderDateRangeVO(dateRange);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getGuidesByRangeStrDateVO/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> getGuidesByRangeStrDateVO(@PathVariable("startDate") String startDate,@PathVariable("finishDate") String finishDate) throws ParseException{
		
		DateRangeVO dateRange = new DateRangeVO();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date dStartDate = format.parse(startDate);
		Date dFinishDate = format.parse(finishDate);
		
		dateRange.setStartDate(dStartDate);
		dateRange.setFinishDate(dFinishDate);
		List<GuideVO> found = guideService.findByOrderDateRangeVO(dateRange);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findById{id}", method = RequestMethod.GET)
	public ResponseEntity<Guide> findById(@PathVariable("id") Long id){
		Guide found = guideService.findById(id);
		
		if(found!=null){
			return new ResponseEntity<Guide>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<Guide>(new Guide(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getTrackingInfo/{guideId}/{deliveryId}", method = RequestMethod.GET)
	public ResponseEntity<List<TrackingVO>> getTrackingInfo(@PathVariable("guideId") String guideId,@PathVariable("deliveryId") String deliveryId){
		List<TrackingVO> found = guideService.getTrackingInfo(guideId, deliveryId);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<TrackingVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<TrackingVO>>(new ArrayList<TrackingVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/saveGuide", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Guide> saveGuide(@RequestBody GuideBeanVO guideBean){
		Guide result = guideService.saveGuide(guideBean.getGuide());
		return new ResponseEntity<Guide>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateGuide", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GuideBeanVO> updateGuide(@RequestBody GuideBeanVO guideBean){
		GuideBeanVO result = guideService.updateGuide(guideBean);
		return new ResponseEntity<GuideBeanVO>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateGuides", method = RequestMethod.GET)
	public ResponseEntity<String> updateGuides(){
		String result = guideService.updateGuides();
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getGuidesByStatusVO/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> getGuidesByStatusVO(@PathVariable("status") String status) throws ParseException{
		
		GuideSearchVO guideSearch = new GuideSearchVO();
		
	    guideSearch.setStatus(status);
		
		List<GuideVO> found = guideService.findByStatus(guideSearch);
		
		if(found!=null && !found.isEmpty()){
			
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getGuidesByStatusDeliveryDateVO/{status}/{deliveryDate}", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> getGuidesByStatusDeliveryDateVO(@PathVariable("status") String status,@PathVariable("deliveryDate") Long deliveryDate) throws ParseException{
		
		GuideSearchVO guideSearch = new GuideSearchVO();
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dDeliveryDate = new Date(deliveryDate);
		
		guideSearch.setDeliveryDate(dDeliveryDate);
		guideSearch.setStatus(status);
		
		List<GuideVO> found = guideService.findByStatusAndDeliveryDate(guideSearch);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getGuidesByStatusProgrammedDateVO/{status}/{programmedDate}", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> getGuidesByStatusProgrammedDateVO(@PathVariable("status") String status,@PathVariable("programmedDate") Long programmedDate) throws ParseException{
		
		GuideSearchVO guideSearch = new GuideSearchVO();
		
		Date dProgrammedDate = new Date(programmedDate);
		System.out.println("Fecha programada "+dProgrammedDate);
		guideSearch.setProgrammedDate(dProgrammedDate);
		guideSearch.setStatus(status);
		
		List<GuideVO> found = guideService.findGuideVOByProgrammedDateAndStatus(guideSearch);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getGuidesByProgrammedDateVO/{programmedDate}", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> getGuidesByProgrammedDateVO(@PathVariable("status") String status,@PathVariable("programmedDate") Date programmedDate) throws ParseException{
		
		GuideSearchVO guideSearch = new GuideSearchVO();
		
		
		guideSearch.setProgrammedDate(programmedDate);
		
		List<GuideVO> found = guideService.findGuideVOByProgrammedDate(guideSearch);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findByDeliveryStatusPaymentMethodVO/{deliveryName}/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> findByDeliveryStatusPaymentMethodVO(@PathVariable("deliveryName") String deliveryName,@PathVariable("status") String status) throws ParseException{
		
		
		
		List<GuideVO> found = guideService.findByDeliveryStatusPaymentMethodVO(deliveryName,status);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getGuidesByStatusDateRangeVO/{status}/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<GuideVO>> getGuidesByStatusDateRangeVO(@PathVariable("status") String status,@PathVariable("startDate") String startDate,@PathVariable("finishDate") String finishDate) throws ParseException{
		
		GuideSearchVO guideSearch = new GuideSearchVO();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dStartDate = format.parse(startDate);
		Date dFinishDate = format.parse(finishDate);
		
		guideSearch.setStartDate(dStartDate);
		guideSearch.setFinishDate(dFinishDate);
		guideSearch.setStatus(status);
		
		List<GuideVO> found = guideService.findByCreateDateBetweenAndStatus(guideSearch);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuideVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuideVO>>(new ArrayList<GuideVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/sendDeliveryNotification/{status}/{deliveryDate}", method = RequestMethod.GET)
	public ResponseEntity<GuideDeliveryNotificationVO> sendDeliveryNotification(@PathVariable("status") String status,@PathVariable("deliveryDate")Date deliveryDate) throws ParseException{
		GuideSearchVO guideSearch = new GuideSearchVO();
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//Date dDeliveryDate = format.parse(deliveryDate);
		
		guideSearch.setDeliveryDate(deliveryDate);
		guideSearch.setStatus(status);
		
		GuideDeliveryNotificationVO found = guideService.sendProgrammedGuides(guideSearch);
		
		return new ResponseEntity<GuideDeliveryNotificationVO>(found,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/processTracking", method = RequestMethod.GET)
	public ResponseEntity<String> processTracking(){
		String result = "OK";
		
		guideService.processGuideTracking();
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/processMigrate", method = RequestMethod.GET)
	public ResponseEntity<String> processMigrate(){
		String result = guideService.processMigrate();
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/doProcessDate", method = RequestMethod.GET)
	public ResponseEntity<GuideProcessResultBean> doProcessDate(){
		GuideProcessResultBean result = guideProcessService.doProcessDate();
		return new ResponseEntity<GuideProcessResultBean>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterGuideStatus/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<Catalog>> filterGuideStatus(@PathVariable("status") String status){
		List<Catalog> found = guideService.filterGuideStatus(status);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<Catalog>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Catalog>>(new ArrayList<Catalog>(),HttpStatus.OK);
		}
	}
	
	
	
	@RequestMapping(value = "/getGuidesPaymentMethod/{deliveryName}/{periode}", method = RequestMethod.GET)
	public ResponseEntity<List<Guide>> getGuidesPaymentMethod(@PathVariable("deliveryName") String deliveryName, @PathVariable("periode") String periode){
		List<Guide> found = guideService.findByPaymentMethodAndDeliveryNameAndPeriode(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName(), deliveryName, periode);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<Guide>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Guide>>(new ArrayList<Guide>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getGuidesByPaymentMethod/{deliveryName}/{periode}", method = RequestMethod.GET)
	public ResponseEntity<List<GuidePaymentVO>> getGuidesByPaymentMethod(@PathVariable("deliveryName") String deliveryName, @PathVariable("periode") String periode){
		List<GuidePaymentVO> found = guideService.findGuidesByPaymentMethodAndDeliveryNameAndPeriode(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName(), deliveryName, periode);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<GuidePaymentVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<GuidePaymentVO>>(new ArrayList<GuidePaymentVO>(),HttpStatus.OK);
		}
	}
}
