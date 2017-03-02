package com.yaesta.app.task;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.service.ClientService;
import com.yaesta.app.persistence.service.GuideProcessService;
import com.yaesta.app.persistence.service.GuideService;
import com.yaesta.integration.vitex.service.OrderVitexService;



@Service
@Component
public class ScheduledTasks implements Serializable {
    
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1402122397893102396L;


	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	
	@Autowired
	OrderVitexService orderVitexService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	GuideService guideService;
	
	@Autowired
	GuideProcessService guideProcessService;
	
	
	 @Scheduled(cron="0 0 1-23 * * SUN-SAT")
	 public void launchTask() {
	    System.out.println("Antes de actualizar items-orders " + dateFormat.format(new Date()));
	    orderVitexService.loadOrderItem();
	    System.out.println("Antes de actualizar customers " + dateFormat.format(new Date()));
	    clientService.updateNewCustomerList();
	 }
	 
	 @Scheduled(cron="0 30 0 * * MON-FRI")
	 public void launchUpdNewCustomer(){
		 System.out.println("Antes de actualizar tracking " + dateFormat.format(new Date()));
		 guideService.processGuideTracking();
	 }
	 
	 @Scheduled(cron="0 30 6 * * SUN-SAT")
	 public void doProcessDate(){
		 System.out.println("Antes de ejecutar inicio de dia " + dateFormat.format(new Date()));
		 guideProcessService.doProcessDate();
	 }
	 
	 @Scheduled(cron="0 45 23 * * SUN-SAT")
	 public void changeProcessDate(){
		 System.out.println("Antes de ejecutar cambio de fecha proceso " + dateFormat.format(new Date()));
		 guideProcessService.changeProcessDate();
	 }
	 
	 @Scheduled(cron="0 55 23 * * SUN-SAT")
	 public void verifyProcessDate(){
		 System.out.println("Antes de ejecutar verificacion de fecha proceso " + dateFormat.format(new Date()));
		 guideProcessService.verifyProcessDate();
	 }
	 
}
