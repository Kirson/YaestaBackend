package com.yaesta.bpm.jbpm;

import javax.persistence.Persistence;

import org.jbpm.runtime.manager.impl.RuntimeEnvironmentBuilder;
import org.jbpm.services.task.identity.JBossUserGroupCallbackImpl;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.task.TaskService;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.manager.RuntimeEnvironment;
import org.kie.internal.runtime.manager.RuntimeManagerFactory;
import org.kie.internal.runtime.manager.context.EmptyContext;
import org.kie.internal.task.api.UserGroupCallback;

@SuppressWarnings("deprecation")
public class JBPMUtil {

	private static RuntimeManager runtimeManager;
	private static RuntimeEngine runtime;
	@SuppressWarnings("unused")
	private static KieSession ksession;
	
	public static RuntimeManager SingletonRuntimeManager(String process) {
		 UserGroupCallback userGroupCallback = new JBossUserGroupCallbackImpl("classpath:/usergroup.properties");
	        RuntimeEnvironment environment = RuntimeEnvironmentBuilder.getDefault()
	        		.entityManagerFactory(Persistence.createEntityManagerFactory("org.jbpm.persistence.jpa"))
	            .userGroupCallback(userGroupCallback)
	            .addAsset(ResourceFactory.newClassPathResource(process), ResourceType.BPMN2)
	            .get();
	        runtimeManager = RuntimeManagerFactory.Factory.get().newSingletonRuntimeManager(environment);
	        return runtimeManager;
	}
	
	
	
	public static KieSession getSingletonSession( ){
		 runtime = runtimeManager.getRuntimeEngine(EmptyContext.get());  
		 return runtime.getKieSession();
	}
	
	
	public static TaskService getTaskService(){
		return runtime.getTaskService();
	}
}
