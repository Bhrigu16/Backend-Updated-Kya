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
@Table(name="users")
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
	@Column(unique=true,nullable = false)
	private String username;
	
	private String full_name;
	
	@Column(nullable = false)
	private String auth_key;
	
	@Column(nullable = false)
	private String password_hash;
	
	@Column(unique=true)
	private String password_reset_token;
	
	@Column(unique=true,nullable = false)
	private String email;
	
	private Long mobile;
	
	@Column(nullable = false)
	private int status;
	
	@Column(nullable = false)
	private Date created_on;
	
	@Column(nullable = false)
	private Date updated_on;
	
	private String verification_token;

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	public user(Long id, String username, String full_name, String auth_key, String password_hash,
			String password_reset_token, String email, Long mobile, int status, Date created_on, Date updated_on,
			String verification_token) {
		super();
		this.id = id;
		this.username = username;
		this.full_name = full_name;
		this.auth_key = auth_key;
		this.password_hash = password_hash;
		this.password_reset_token = password_reset_token;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.created_on = created_on;
		this.updated_on = updated_on;
		this.verification_token = verification_token;
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

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public String getPassword_reset_token() {
		return password_reset_token;
	}

	public void setPassword_reset_token(String password_reset_token) {
		this.password_reset_token = password_reset_token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public String getVerification_token() {
		return verification_token;
	}

	public void setVerification_token(String verification_token) {
		this.verification_token = verification_token;
	}

	@Override
	public int hashCode() {
		return Objects.hash(auth_key, created_on, email, full_name, id, mobile, password_hash, password_reset_token,
				status, updated_on, username, verification_token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		user other = (user) obj;
		return Objects.equals(auth_key, other.auth_key) && Objects.equals(created_on, other.created_on)
				&& Objects.equals(email, other.email) && Objects.equals(full_name, other.full_name)
				&& Objects.equals(id, other.id) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(password_hash, other.password_hash)
				&& Objects.equals(password_reset_token, other.password_reset_token) && status == other.status
				&& Objects.equals(updated_on, other.updated_on) && Objects.equals(username, other.username)
				&& Objects.equals(verification_token, other.verification_token);
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", full_name=" + full_name + ", auth_key=" + auth_key
				+ ", password_hash=" + password_hash + ", password_reset_token=" + password_reset_token + ", email="
				+ email + ", mobile=" + mobile + ", status=" + status + ", created_on=" + created_on + ", updated_on="
				+ updated_on + ", verification_token=" + verification_token + "]";
	}
	
	
	
	
	
}
