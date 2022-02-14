package com.backend.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mst_roles")
public class roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	private String role_name;
	
	@Column(nullable = false)
	private boolean is_active;
	
	@Column(nullable = false)
	private boolean is_deleted;

	
	public roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public roles(Long id, String role_name, boolean is_active, boolean is_deleted) {
		super();
		this.id = id;
		this.role_name = role_name;
		this.is_active = is_active;
		this.is_deleted = is_deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, is_active, is_deleted, role_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		roles other = (roles) obj;
		return Objects.equals(id, other.id) && is_active == other.is_active && is_deleted == other.is_deleted
				&& Objects.equals(role_name, other.role_name);
	}

	@Override
	public String toString() {
		return "roles [id=" + id + ", role_name=" + role_name + ", is_active=" + is_active + ", is_deleted="
				+ is_deleted + "]";
	}

	
	
}
