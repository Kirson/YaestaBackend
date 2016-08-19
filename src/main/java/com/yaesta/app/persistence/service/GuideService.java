package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.GuideDetail;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.repository.GuideDetailRepository;
import com.yaesta.app.persistence.repository.GuideRepository;

@Service
public class GuideService {
	
	@Autowired
	private GuideRepository guideRepository;
	
	@Autowired
	private GuideDetailRepository guideDetailRepository;
	
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
		guideRepository.save(guide);
		return guide;
	}
	
	public List<Guide> getAll(){
		return guideRepository.findAll();
	}

}
