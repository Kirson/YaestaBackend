package com.yaesta.app.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yaesta.integration.vitex.service.OrderVitexService;



@Service
@Component
public class ScheduledTasks {
    
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	
	@Autowired
	OrderVitexService orderVitexService;
	
	
	 @Scheduled(initialDelay = 30000, fixedDelay=600000)
	 public void launchTask() {
	    System.out.println("Antes de actualizar items-orders " + dateFormat.format(new Date()));
	   //orderVitexService.loadOrderItem();
	 }
	 
}
