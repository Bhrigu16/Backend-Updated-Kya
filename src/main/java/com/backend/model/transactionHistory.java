package com.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trans_mst_history")
public class transactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private Long user_id;
	
	@Column(nullable = false)
	private Date created_on;
	
	@Column(nullable = false)
	private Long created_by_role_id;
	
	@Column(nullable = false)
	private Long gid_kml;
	
	@Column(nullable = false)
	private String remote_ip_address;
	
	@Column(nullable = false)
	private String remote_user_agent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Long getCreated_by_role_id() {
		return created_by_role_id;
	}

	public void setCreated_by_role_id(Long created_by_role_id) {
		this.created_by_role_id = created_by_role_id;
	}

	public Long getGid_kml() {
		return gid_kml;
	}

	public void setGid_kml(Long gid_kml) {
		this.gid_kml = gid_kml;
	}

	public String getRemote_ip_address() {
		return remote_ip_address;
	}

	public void setRemote_ip_address(String remote_ip_address) {
		this.remote_ip_address = remote_ip_address;
	}

	public String getRemote_user_agent() {
		return remote_user_agent;
	}

	public void setRemote_user_agent(String remote_user_agent) {
		this.remote_user_agent = remote_user_agent;
	}
	
	
	
}
