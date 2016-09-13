package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.GuideDetail;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.repository.GuideDetailRepository;
import com.yaesta.app.persistence.repository.GuideRepository;
import com.yaesta.app.persistence.vo.DateRangeVO;
import com.yaesta.app.persistence.vo.GuideVO;
import com.yaesta.app.persistence.vo.TrackingVO;
import com.yaesta.app.util.GuideUtil;
import com.yaesta.app.util.TrackingUtil;
import com.yaesta.integration.tramaco.dto.GuideBeanDTO;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.service.TramacoService;

import dmz.comercial.servicio.cliente.dto.SalidaTrackGuiaWs;

@Service
public class GuideService {
	
	@Autowired
	private GuideRepository guideRepository;
	
	@Autowired
	private GuideDetailRepository guideDetailRepository;
	
	@Autowired
	private TramacoService tramacoService;
	
	public List<Guide> findByOrder(Order order){
		List<Guide> result = new ArrayList<Guide>();
		List<Guide> founds = guideRepository.findByOrder(order);
		
		if(founds!=null && !founds.isEmpty())
		{
			for(Guide g:founds){
				List<GuideDetail> gdList = guideDetailRepository.findByGuide(g);
				g.setDetails(gdList);
				result.add(g);
			}
		}
		
		return result;
	}
	
	public Guide saveGuide(Guide guide){
		
		if(guide.getGuideStatus()!=null){
			guide.setStatus(guide.getGuideStatus().getNemonic());
		}
		guideRepository.save(guide);
		return guide;
	}
	
	public List<Guide> getAll(){
		return guideRepository.findAll();
	}
	
	public List<GuideVO> getAllVO(){
		List<GuideVO> resultList = new ArrayList<GuideVO>();
		List<Guide> found = guideRepository.findAll();
		
		if(found!=null && !found.isEmpty()){
			for(Guide g:found){
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				resultList.add(gvo);
			}
		}
		
		return resultList;
	}
	
	public List<GuideVO> findByDateRangeVO(DateRangeVO dateRange){
		List<Guide> found =guideRepository.findByCreateDateBetween(dateRange.getStartDate(), dateRange.getFinishDate());
		List<GuideVO> resultList = new ArrayList<GuideVO>();
		if(found!=null && !found.isEmpty()){
			for(Guide g:found){
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				resultList.add(gvo);
			}
		}
		return resultList;
	}
	
	public List<Guide> findByDeliveryName(String deliveryName){
		return guideRepository.findByDeliveryName(deliveryName);
	}
	
	@Transactional
	public Guide saveGuideDetail(Guide guide, List<GuideDetail> details){
		
		if(details!=null && !details.isEmpty()){
			for(GuideDetail gd:details){
				gd.setGuide(guide);
				guideDetailRepository.save(gd);
			}
		}
		
		return guide;
	}
	
	public Guide findById(Long id){
		return guideRepository.findOne(id);
	}
	
	public List<TrackingVO> getTrackingInfo(String guideId, String deliveryId){
		List<TrackingVO> trackingList = new ArrayList<TrackingVO>();
		
		if(deliveryId.equals("TRAMACO")){
			GuideDTO guideInfo = new GuideDTO();
			GuideBeanDTO gbd = new GuideBeanDTO();
			gbd.setGuideDeliveryId(guideId);
			guideInfo.setGuideBean(gbd);
			GuideDTO response=tramacoService.trackingService(guideInfo);
			
			if(response.getGuideBean().getGuideTrackResponse().getLstSalidaTrackGuiaWs()!=null && !response.getGuideBean().getGuideTrackResponse().getLstSalidaTrackGuiaWs().isEmpty()){
				for(SalidaTrackGuiaWs st:response.getGuideBean().getGuideTrackResponse().getLstSalidaTrackGuiaWs()){
					TrackingVO tvo = TrackingUtil.fromSalidaTrackGuiaWsToTrackingVO(st);
					trackingList.add(tvo);
				}
			}
		}
		
		return trackingList;
	}

}
