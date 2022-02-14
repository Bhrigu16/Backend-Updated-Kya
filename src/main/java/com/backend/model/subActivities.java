package com.backend.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_sub_activities")
public class subActivities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//Activity_Id link from activity table
	//Foreign Key
	@Column(nullable=false)
	private Long activityId;
	
	@Column(nullable = false)
	private String sub_activity_name;
	
	private String threshold_parameter;
	
	private Long threshold_value;
	
	
	private EnumThreshold threshold_unit;
	
	@Column(nullable = false)
	private Date created_on;
	
	//Foreign Key link to user
	@Column(nullable = false)
	private Long created_by;
	
	@Column(nullable = false)
	private Date updated_on;
	
	//Foreign Key link to user
	@Column(nullable = false)
	private Long updated_by;
	
	@Column(nullable = false)
	private boolean is_active;
	
	@Column(nullable = false)
	private boolean is_deleted;
	
	private String remarks;

	public subActivities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public subActivities(Long id, Long activityId, String sub_activity_name, String threshold_parameter,
			Long threshold_value, EnumThreshold threshold_unit, Date created_on, Long created_by, Date updated_on,
			Long updated_by, boolean is_active, boolean is_deleted, String remarks) {
		super();
		this.id = id;
		this.activityId = activityId;
		this.sub_activity_name = sub_activity_name;
		this.threshold_parameter = threshold_parameter;
		this.threshold_value = threshold_value;
		this.threshold_unit = threshold_unit;
		this.created_on = created_on;
		this.created_by = created_by;
		this.updated_on = updated_on;
		this.updated_by = updated_by;
		this.is_active = is_active;
		this.is_deleted = is_deleted;
		this.remarks = remarks;
	}


	public Long getThreshold_value() {
		return threshold_value;
	}

	public void setThreshold_value(Long threshold_value) {
		this.threshold_value = threshold_value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getSub_activity_name() {
		return sub_activity_name;
	}

	public void setSub_activity_name(String sub_activity_name) {
		this.sub_activity_name = sub_activity_name;
	}

	public String getThreshold_parameter() {
		return threshold_parameter;
	}

	public void setThreshold_parameter(String threshold_parameter) {
		this.threshold_parameter = threshold_parameter;
	}

	public EnumThreshold getThreshold_unit() {
		return threshold_unit;
	}

	public void setThreshold_unit(EnumThreshold threshold_unit) {
		this.threshold_unit = threshold_unit;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public Long getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Long updated_by) {
		this.updated_by = updated_by;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
}
