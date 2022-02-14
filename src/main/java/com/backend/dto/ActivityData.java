package com.backend.dto;

public class ActivityData {
	private long activityId;
	private long subActivityId;
	private String activity;
	private String subactivity;
	private int capacity;
	
	public long getSubActivityId() {
		return subActivityId;
	}
	public void setSubActivityId(long subActivityId) {
		this.subActivityId = subActivityId;
	}
	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getSubactivity() {
		return subactivity;
	}
	public void setSubactivity(String subactivity) {
		this.subactivity = subactivity;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "ActivityData [activityId=" + activityId + ", subActivityId=" + subActivityId + ", activity=" + activity
				+ ", subactivity=" + subactivity + ", capacity=" + capacity + "]";
	}
	

	
}
