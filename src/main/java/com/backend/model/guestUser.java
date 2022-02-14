package com.backend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guest_User")
public class guestUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String remote_IP;
	
	private String remote_UserAgent;
	
	private Long gid_Kml;

	public guestUser(Long id, String username, String remoteIP, String remoteUserAgent, Long gidKml) {
		super();
		this.id = id;
		this.username = username;
		this.remote_IP = remoteIP;
		this.remote_UserAgent = remoteUserAgent;
		this.gid_Kml = gidKml;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRemoteIP() {
		return remote_IP;
	}

	public void setRemoteIP(String remoteIP) {
		this.remote_IP = remoteIP;
	}

	public String getRemoteUserAgent() {
		return remote_UserAgent;
	}

	public void setRemoteUserAgent(String remoteUserAgent) {
		this.remote_UserAgent = remoteUserAgent;
	}

	public Long getGidKml() {
		return gid_Kml;
	}

	public void setGidKml(Long gidKml) {
		this.gid_Kml = gidKml;
	}

	public guestUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
