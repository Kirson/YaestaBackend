package com.yaesta.app.persistence.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.yaesta.app.pdf.bean.GuideProcessBean;
import com.yaesta.app.pdf.bean.GuideProcessResultBean;
import com.yaesta.app.pdf.enums.GuideStatusEnum;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.GuideProcess;
import com.yaesta.app.persistence.entity.Parameter;
import com.yaesta.app.persistence.repository.GuideProcessRepository;
import com.yaesta.app.persistence.repository.GuideRepository;
import com.yaesta.app.persistence.repository.ParameterRepository;
import com.yaesta.app.util.UtilDate;

@Service
public class GuideProcessService {

	@Autowired
	private GuideProcessRepository guideProcessRepository;

	@Autowired
	private GuideRepository guideRepository;

	@Autowired
	private ParameterRepository parameterRepository;

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;

	private @Value("${parameter.date.process}") String parameterDateProcess;

	public GuideProcess findByProcessDate(Date processDate) {

		GuideProcess result = null;

		List<GuideProcess> found = guideProcessRepository.findByProcessDate(processDate);

		if (found != null && !found.isEmpty()) {
			result = found.get(0);
		}

		return result;
	}

	public GuideProcess save(GuideProcess guideProcess) {
		return guideProcessRepository.save(guideProcess);
	}
	
	public List<GuideProcess> findByClosedDate(Boolean closedDate){
		return guideProcessRepository.findByClosedDate(closedDate);
	}

	@Transactional
	public GuideProcessResultBean doProcessDate() {
		GuideProcessResultBean result = new GuideProcessResultBean();
		try {
			// Obtener la fecha de proceso actual
			Parameter pDateProcess = parameterRepository.findByNemonic(parameterDateProcess);
			// Convertir el valor a tipo fecha

			Date dDateProcess = UtilDate.fromStringToDate(pDateProcess.getValue());

			Long totalProgrammedGuides = guideRepository.countByProgrammedDate(dDateProcess);

			List<GuideProcessBean> listGuideProcess = new ArrayList<GuideProcessBean>();

			// Iterar todos los estados
			for (GuideStatusEnum gse : GuideStatusEnum.values()) {
				GuideProcessBean gpb = new GuideProcessBean();
				gpb.setStatus(gse.getCode());
				gpb.setDateProcess(pDateProcess.getValue());
				Long countStatus = guideRepository.countByProgrammedDateAndStatus(dDateProcess, gse.getCode());
				gpb.setCount(countStatus);
				listGuideProcess.add(gpb);
			}

			// Verificar si existe o el dia de proceso en el resumen
			GuideProcess todayProcess = this.findByProcessDate(dDateProcess);

			if (todayProcess == null) {
				todayProcess = new GuideProcess();
				todayProcess.setProcessDate(dDateProcess);
			}

			// Iterar lista y guardar los valores
			todayProcess.setTotalGuides(totalProgrammedGuides);
			for (GuideProcessBean gpb : listGuideProcess) {
				if (gpb.getStatus().equals(GuideStatusEnum.PROGRAMED.getCode())) {
					todayProcess.setNumProgrammed(gpb.getCount());
				} else if (gpb.getStatus().equals(GuideStatusEnum.CANCELED.getCode())) {
					todayProcess.setNumCanceled(gpb.getCount());
				} else if (gpb.getStatus().equals(GuideStatusEnum.DELIVERED.getCode())) {
					todayProcess.setNumDelivery(gpb.getCount());
				} else if (gpb.getStatus().equals(GuideStatusEnum.DELIVERY_PENDING.getCode())) {
					todayProcess.setNumDeliveryPending(gpb.getCount());
				} else if (gpb.getStatus().equals(GuideStatusEnum.PENDING.getCode())) {
					todayProcess.setNumDeliveryPending(gpb.getCount());
				}

			}
			
			guideProcessRepository.save(todayProcess);
			
			result.setMessage("OK");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setIsOk(Boolean.FALSE);
			result.setMessage("Error "+e.getMessage());
		}
		
		return result;

	}
	
	@Transactional
	public GuideProcessResultBean changeProcessDate() {
		GuideProcessResultBean result = new GuideProcessResultBean();
		try {
			
			// Obtener la fecha de proceso actual
			Parameter pDateProcess = parameterRepository.findByNemonic(parameterDateProcess);
			// Convertir el valor a tipo fecha

			Date dDateProcess = UtilDate.fromStringToDate(pDateProcess.getValue());
			
			//Actualizar el estado de todas las guias a Delivery-Pending
			List<Guide> guideProgramedList = guideRepository.findByProgrammedDateAndStatus(dDateProcess, GuideStatusEnum.PROGRAMED.getCode());
			
			if(guideProgramedList!=null & !guideProgramedList.isEmpty()){
				for(Guide guide:guideProgramedList){
					guide.setStatus(GuideStatusEnum.DELIVERY_PENDING.getCode());
					guide.setUpdDate(new Date());
					guideRepository.save(guide);
				}
			}

			//Cambiar la nueva fecha de proceso
			Date newDateProcess = UtilDate.addDate(dDateProcess, 1);
			
			String strNewDateProcess = UtilDate.fromDateToString(newDateProcess, "yyyy-MM-dd");
			
			pDateProcess.setValue(strNewDateProcess);
			
			parameterRepository.save(pDateProcess);
			
			result.setMessage("OK");
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setIsOk(Boolean.FALSE);
			result.setMessage("Error "+e.getMessage());
		}
		
		return result;
	}
	
	@Transactional
	public void verifyProcessDate(){ //Verifica y cierra las fechas de proceso
		//Obtener todas las que mantengan fechas abiertas
		List<GuideProcess> allOpenDays = this.findByClosedDate(Boolean.FALSE);
		
		if(allOpenDays!=null && !allOpenDays.isEmpty()){
			
			for(GuideProcess gp:allOpenDays){
				Long total = gp.getTotalGuides();
				Long control = 0L;
				control = gp.getNumCanceled() + gp.getNumDelivery();
				
				if(total.longValue()==control.longValue()){
					gp.setClosedDate(Boolean.TRUE);
					guideProcessRepository.save(gp);
				}
			}
		}
			
	}
}
