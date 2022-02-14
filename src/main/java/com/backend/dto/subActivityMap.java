package com.backend.dto;

import com.backend.model.EnumThreshold;

public class subActivityMap {
	long subactivityId;

	String sub_activity_name;

	private Long threshold_value;
	private EnumThreshold threshold_unit;

	public String getSub_activity_name() {
		return sub_activity_name;
	}

	public long getSubactivityId() {
		return subactivityId;
	}

	public EnumThreshold getThreshold_unit() {
		return threshold_unit;
	}

	public void setThreshold_unit(EnumThreshold threshold_unit) {
		this.threshold_unit = threshold_unit;
	}

	public void setSubactivityId(long subactivityId) {
		this.subactivityId = subactivityId;
	}

	public void setSub_activity_name(String sub_activity_name) {
		this.sub_activity_name = sub_activity_name;
	}

	public Long getThreshold_value() {
		return threshold_value;
	}

	public void setThreshold_value(Long threshold_value) {
		this.threshold_value = threshold_value;
	}

}
