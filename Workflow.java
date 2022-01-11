package com.taskdemo.model;

import java.util.HashMap;
import java.util.Map;
import static com.taskdemo.model.PointType.*;

public class Workflow {
	
	Map<Integer, Task> tasks = new HashMap<>();
	Map<Integer, WorkflowPoint> workflowPoints = new HashMap<>();
	
	/**
	 * Adds tasks from Task table
	 * @param id task id
	 */
	void addTask(int id) {
		Task task = null; // TO-DO: GET TASK FROM FACTORY CLASS
		tasks.put(id, task);
	}
	

	/**
	 * Add points in workflow from WorkFlowPoint table
	 * 
	 * @param id
	 * @param pointType (START,DECISION, END)
	 * @param decisionPoint
	 * @param taskId
	 * @param success
	 * @param failure
	 */
	void addWorkflowPoint(int id, int pointType, boolean decisionPoint,Integer taskId, Integer success, Integer failure) {
		    // TO-DO: GET WORK FLOW POINT FROM FACTORY CLASS
			WorkflowPointImpl point = new WorkflowPointImpl(PointType.valueOfType(pointType), taskId, success, failure);
			workflowPoints.put(id, point);
	}
	
	/**
	 * Executes workflow using logic defined in WorkFlowPoint table
	 * 
	 * @param nextPoint Start point for workflow logic
	 */
	void processTasks(WorkflowPointImpl nextPoint ) {
		if (nextPoint.pointType!=START_POINT) {
			throw new IllegalArgumentException( "workflow must begin with start point");
		}
		Object outputFromTask = null;
		while (nextPoint.pointType==DECISION_POINT) {
			Task task = tasks.get(nextPoint.taskId);
			outputFromTask = task.execute(null);
			boolean success = nextPoint.evaluateOutput(outputFromTask);
			if (success==true) {
				WorkflowPoint w = workflowPoints.get(nextPoint.successWorkFlowPointId);
			} else {
				WorkflowPoint w = workflowPoints.get(nextPoint.failureWorkFlowPointId);
			}
		}
		
		if (nextPoint.pointType!=END_POINT) {
			throw new IllegalArgumentException( "workflow must end with end point");
		}
		nextPoint.evaluateOutput(outputFromTask);
	}

}