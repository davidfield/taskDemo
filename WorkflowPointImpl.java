package com.taskdemo.model;

public class WorkflowPointImpl implements WorkflowPoint {
	
	Integer taskId;
	PointType pointType;
	Integer successWorkFlowPointId;
	Integer failureWorkFlowPointId;
	
	public WorkflowPointImpl(PointType pointType, Integer taskId, Integer successWorkFlowPointId, Integer failureWorkFlowPointId) {
		super();
		this.pointType = pointType;
		this.taskId = taskId;
		this.successWorkFlowPointId = successWorkFlowPointId;
		this.failureWorkFlowPointId = failureWorkFlowPointId;
	}

	public boolean evaluateOutput(Object outputFromTask) {
		return true;
	}
	

}
