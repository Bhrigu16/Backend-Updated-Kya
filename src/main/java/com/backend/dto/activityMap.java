package com.backend.dto;

import java.util.ArrayList;
import java.util.List;

import com.backend.model.EnumThreshold;

public class activityMap {
	long activityId;

	String activity_name;
	
	//List<String> subActivity_name=new ArrayList<String>();
	
	List<subActivityMap> subactivityMap=new ArrayList<subActivityMap>();
	
	public List<subActivityMap> getSubactivityMap() {
		return subactivityMap;
	}

	public void setSubactivityMap(subActivityMap subactivityMap) {
		this.subactivityMap.add(subactivityMap);
	}
	


	String threshold_parameter;
	
	private EnumThreshold threshold_unit;
	
	Long threshold_value;

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

//	public List<String> getSubActivity_name() {
//		return subActivity_name;
//	}

//	public void addSubActivity_name(String subActivity_name) {
//		//System.out.println("--------------Here"+subActivity_name);
//		this.subActivity_name.add(subActivity_name);
//		//System.out.println("--------------Afterrrrr"+subActivity_name);
//	}

	public String getthreshold_parameter() {
		return threshold_parameter;
	}

	public void setthreshold_parameter(String threshold_parameter) {
		this.threshold_parameter = threshold_parameter;
	}

	public EnumThreshold getThreshold_unit() {
		return threshold_unit;
	}

	public long getActivityId() {
		return activityId;
	}
	
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public void setThreshold_unit(EnumThreshold threshold_unit) {
		this.threshold_unit = threshold_unit;
	}

	public Long getthreshold_value() {
		return threshold_value;
	}

	public void setthreshold_value(Long threshold_value) {
		this.threshold_value = threshold_value;
	}
	
	
}
