package com.taskdemo.model;

public enum PointType {
	
	START_POINT(0), DECISION_POINT(1), END_POINT(2);
	
	PointType(Integer type ){
		this.type = type;
	}

	Integer type;
	
	public static PointType valueOfType(Integer type) {
	    for (PointType e : values()) {
	        if (e.type.equals(type)) {
	            return e;
	        }
	    }
	    return null;
	}
	
}
