package com.yaesta.integration.bpm.jbpm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.WorkflowProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.TaskSummary;



/*
 * REST API methods to process jBPM tasks
 */


/*
 * Tasks for an user
 */
@Path("/json/tasks")
public class BPMRestService {

	@SuppressWarnings("unused")
	@POST
	@Path("/pending")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskData>  getTasks(@QueryParam("user") String user) throws NamingException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

		
		KieSession ksession = JBPMUtil.getSingletonSession();
        TaskService taskService = JBPMUtil.getTaskService();
        
    	java.util.List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner(user, "en-UK");
		
    	List <TaskData> reqTasks = new ArrayList<TaskData>();
    	TaskData tdata = null;
    	
    	for (int i = 0; i < tasks.size(); i++) {
    		tdata = new TaskData();
    		tdata.setId(tasks.get(i).getId());
    		tdata.setName(tasks.get(i).getName());
    		tdata.setOwner(tasks.get(i).getActualOwner().toString());
    		tdata.setProcessId((tasks.get(i).getProcessInstanceId()));
    		tdata.setStatus(tasks.get(i).getStatus().toString());
    		reqTasks.add(tdata);
    	}
    	
    	return reqTasks;
	}
	
	/*
	 * Paramters for a process ID
	 */
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@POST
	@Path("/processparams")
	@Produces(MediaType.APPLICATION_JSON)
	public Map  getParams(@QueryParam("processId") String processId) throws NamingException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

		
		 KieSession ksession = JBPMUtil.getSingletonSession();
			TaskService taskService = JBPMUtil.getTaskService();
		 
         Long procId = new Long((String)processId);
         
         
         WorkflowProcessInstance process = (WorkflowProcessInstance)ksession.getProcessInstance(procId);
		 Map<String, Object> params = new HashMap<String, Object>();
         
			params.put("priority", process.getVariable("priority"));

	        
			params.put("modelNumber", process.getVariable("modelNumber"));
			params.put("quantity",process.getVariable("quantity"));
			
			
 		return params;
	}
	
	
	/*
	 * Complete a task using the paramters taskID, model number etc
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/compleTask")
	public List  compleTask(@QueryParam("user") String user,
            @QueryParam("taskId") String taskId,
            @QueryParam("priority") String priority,
            @QueryParam("modelNumber") String modelNumber,
            @QueryParam("quantity") String quantity) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException, NamingException {
	
		
		   UserTransaction ut = (UserTransaction) new InitialContext()
		    .lookup("java:comp/UserTransaction");
             ut.begin();
             
		    TaskService taskService = JBPMUtil.getTaskService();
		 
   		    /*
			 * Start a task for user
			 */
		    long tasknum = new Long(taskId).longValue();
			taskService.start(tasknum, user);
			
			/*
			 * complete the task for user
			 */
			
			Map data = new HashMap();
       	    data.put("priority",priority);
       	    data.put("modelNumber",modelNumber);
       	    data.put("quantity",quantity);
			taskService.complete(tasknum, user, data);
	        
	    	java.util.List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner(user, "en-UK");
	    	
	    	List <TaskData> reqTasks = new ArrayList<TaskData>();
	    	TaskData tdata = null;
	    	
	    	for (int i = 0; i < tasks.size(); i++) {
	    		tdata = new TaskData();
	    		tdata.setId(tasks.get(i).getId());
	    		tdata.setName(tasks.get(i).getName());
	    		tdata.setOwner(tasks.get(i).getActualOwner().toString());
	    		tdata.setProcessId((tasks.get(i).getProcessInstanceId()));
	    		tdata.setStatus(tasks.get(i).getStatus().toString());
	    		reqTasks.add(tdata);
	    	}
	      
	    	
	    	ut.commit();
 		return reqTasks;
	}
	
	/*
	 * Create a process with a given parameters
	 */
	
	@SuppressWarnings("unused")
	@POST
	@Produces("text/plain")
	@Path("/createProcess")
	public String  createProcess( @QueryParam("priority") String priority,
            @QueryParam("modelNumber") String modelNumber,
            @QueryParam("quantity") String quantity) throws NamingException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException  {
		
		
			UserTransaction ut = (UserTransaction) new InitialContext()
				.lookup("java:comp/UserTransaction");
			ut.begin();

			/*
			 * Get the task service and start the process uisng the parameters received
			 */
			KieSession ksession = JBPMUtil.getSingletonSession();
			TaskService taskService = JBPMUtil.getTaskService();

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("priority", priority);
			params.put("modelNumber", modelNumber);
			params.put("quantity",quantity);

			ksession.startProcess("com.sample.bpmn.sampleHTformvariables",
					params);
			System.out.println(" after start");
			// ksession.fireAllRules();
			ut.commit();
		
		return Boolean.toString(true);
	}
	
}
