package com.yaesta.app.task;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
	
	
	 @Scheduled(initialDelay = 30000, fixedDelay=1800000)
	 public void launchTask() {
	    System.out.println("Antes de actualizar items-orders " + dateFormat.format(new Date()));
	    orderVitexService.loadOrderItem();
	 }
	 
}
