package com.yaesta.app.persistence.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.service.GuideService;
import com.yaesta.app.persistence.vo.DateRangeVO;
import com.yaesta.app.persistence.vo.GuideBeanVO;
import com.yaesta.app.persistence.vo.GuideDeliveryNotificationVO;
import com.yaesta.app.persistence.vo.GuideSearchVO;
import com.yaesta.app.persistence.vo.GuideVO;
import com.yaesta.app.persistence.vo.TrackingVO;

@RestController
@RequestMapping(value = "/guide")
public class GuideController implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2760971642899873273L;
	
	@Autowired
	GuideService guideService;
	
	@RequestMapping(value = "/getAll/", method = RequestMethod.GET)
	public ResponseEntity<List<Guide>> getAll(){
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
	public ResponseEntity<List<GuideVO>> getGuidesByStatusDeliveryDateVO(@PathVariable("status") String status,@PathVariable("deliveryDate") Date deliveryDate) throws ParseException{
		
		GuideSearchVO guideSearch = new GuideSearchVO();
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//Date dDeliveryDate = format.parse(deliveryDate);
		
		guideSearch.setDeliveryDate(deliveryDate);
		guideSearch.setStatus(status);
		
		List<GuideVO> found = guideService.findByStatusAndDeliveryDate(guideSearch);
		
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
		
		List<GuideVO> found = guideService.findByStatusAndDeliveryDate(guideSearch);
		
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
}
