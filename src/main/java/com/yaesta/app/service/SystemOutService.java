package com.yaesta.app.service;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.service.YaEstaLogService;

@Service
public class SystemOutService implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7076904526090186870L;

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;
	
	@Autowired
	private YaEstaLogService logService;
	
	private @Value("${yaesta.log.system.out}") String printSystemOut;
	private @Value("${yaesta.log.database}") String printDatabase;
	
	
	
	
	public void println(String line){
		
		if(printSystemOut.equals("Y")){
			print(line,null);
		}else if(printDatabase.equals("Y")){
			YaEstaLog yalog = new YaEstaLog();
			yalog.setLogDate(new Date());
			yalog.setProcessName("SYSTEM-OUT");
			yalog.setErrorinfo(line);
			logService.save(yalog);
		}
		
	}
	
	public void println(Exception exception){
		
		if(printSystemOut.equals("Y")){
			print(null,exception);
		}else if(printDatabase.equals("Y")){
			YaEstaLog yalog = new YaEstaLog();
			yalog.setLogDate(new Date());
			yalog.setProcessName("SYSTEM-OUT");
			yalog.setErrorinfo(exception.getMessage());
			logService.save(yalog);
		}
		
	}
	
	private void print(String line, Exception exception){
		try{
			
			if(exception==null){
				System.out.println(line);
			}else{
				System.out.println("Exception "+exception.getMessage());
				exception.printStackTrace();
			}
			
		}catch(Exception e){
			YaEstaLog yalog = new YaEstaLog();
			yalog.setLogDate(new Date());
			yalog.setProcessName("SYSTEM-OUT-ERROR");
			yalog.setErrorinfo(e.getMessage());
			logService.save(yalog);
		}
	}
	
}
