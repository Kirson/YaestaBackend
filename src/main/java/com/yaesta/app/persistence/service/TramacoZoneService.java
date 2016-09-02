package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.repository.TramacoZoneRepository;
import com.yaesta.app.persistence.vo.CantonVO;
import com.yaesta.app.persistence.vo.ParroquiaVO;
import com.yaesta.app.persistence.vo.ProvinciaVO;

@Service
public class TramacoZoneService {

	@Autowired
	TramacoZoneRepository tramacoZoneRepository;
	
	public List<TramacoZone> getByProvincia(String provincia){
		return tramacoZoneRepository.findByProvincia(provincia);
	}
	
	public List<TramacoZone> getByCanton(String canton){
		return tramacoZoneRepository.findByCanton(canton);
	}
	
	public List<TramacoZone> getAll(){
		return tramacoZoneRepository.findAll();
	}
	
	public List<TramacoZone> getByProvinciaCanton(String provincia, String canton){
		return tramacoZoneRepository.findByProvinciaAndCanton(provincia, canton);
	}
	
	public TramacoZone getByProvinciaCantonParroquia(String provincia, String canton, String parroquia){
		List<TramacoZone> query = tramacoZoneRepository.findByProvinciaAndCantonAndParroquia(provincia, canton,parroquia);
		if(query!=null && !query.isEmpty()){
			return query.get(0);
		}else{
			return null;
		}
	}
	
	
	public List<ProvinciaVO> findZones(){
		List<ProvinciaVO> result = new ArrayList<ProvinciaVO>();
		
		List<String> provinces = tramacoZoneRepository.findAllProvinces();
		
		if(provinces!=null && !provinces.isEmpty()){
			for(String p:provinces){
				if(!p.equals("TODOS")){
					ProvinciaVO tz = new ProvinciaVO();
					tz.setProvincia(p);
					List<TramacoZone> cantonesTramaco = tramacoZoneRepository.findDistinctCantonByProvincia(p);
				
					for(TramacoZone tzc:cantonesTramaco){
						if(!tz.getCantones().contains(tzc.getCanton())){
							CantonVO cvo = new CantonVO();
							cvo.setNombre(tzc.getCanton());
							List<TramacoZone> parroquiasTramaco = tramacoZoneRepository.findByProvinciaAndCanton(p, tzc.getCanton());
							for(TramacoZone tzp:parroquiasTramaco){
								ParroquiaVO pvo = new ParroquiaVO();
								pvo.setNombre(tzp.getParroquia());
								cvo.getParroquias().add(pvo);
							}
							tz.getCantones().add(cvo);
						}
					}
				
					result.add(tz);
				}
			}
		}
		
		return result;
	}
	
}
