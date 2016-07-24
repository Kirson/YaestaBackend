package com.yaesta.integration.bpm.jbpm;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.h2.tools.DeleteDbFiles;
import org.h2.tools.Server;
import org.kie.api.runtime.manager.RuntimeManager;

public class ServletJBPMContext implements ServletContextListener {

	private static Log log = LogFactory.getLog(ServletJBPMContext.class);
	
	@SuppressWarnings("unused")
	@Override
    public void contextInitialized(ServletContextEvent arg0) 
    {        
		 
		 /*
		  * Start H2 Database
		  */
		try {
			
			DeleteDbFiles.execute("", "JPADroolsFlow", true);
			 Server h2Server = Server.createTcpServer(new String[0]);
			h2Server.start();
		} catch (SQLException e) {
			log.error(e.getMessage(), e.getCause());
			throw new RuntimeException("can't start h2 server db",e);
		}
		
		/*
		 * Create the runtime manager using the sample process
		 */
		RuntimeManager manager = JBPMUtil.SingletonRuntimeManager("taskexample/SampleHumanTaskFormVariables.bpmn");	          
   
		
    }


    @Override
    public void contextDestroyed(ServletContextEvent arg0) 
    {
    	 File tempDir = new File(System.getProperty("java.io.tmpdir"));
         //System.out.println(" tempdir is ****" +tempDir);
         if (tempDir.exists()) {            
             String[] jbpmSerFiles = tempDir.list(new FilenameFilter() {                
                 public boolean accept(File dir, String name) {                    
                     return name.endsWith("-jbpmSessionId.ser");
                 }
             });
             for (String file : jbpmSerFiles) {
                 
                 new File(tempDir, file).delete();
             }
         }
    }

}
