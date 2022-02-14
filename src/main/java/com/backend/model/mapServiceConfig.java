package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="map_service_configuration")
public class mapServiceConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long map_id;
	
	@Column(nullable = false)
	private String layer_name;
	
	@Column(nullable = false)
	private String source;
	
	@Column(nullable = false)
	private String service_name;
	
	@Column(nullable = false)
	private boolean status;
	
	private String remarks;
	
	private String zoom_extend;
	
	private String maxzoom_scale;

	public Long getMap_id() {
		return map_id;
	}

	public void setMap_id(Long map_id) {
		this.map_id = map_id;
	}

	public String getLayer_name() {
		return layer_name;
	}

	public void setLayer_name(String layer_name) {
		this.layer_name = layer_name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getZoom_extend() {
		return zoom_extend;
	}

	public void setZoom_extend(String zoom_extend) {
		this.zoom_extend = zoom_extend;
	}

	public String getMaxzoom_scale() {
		return maxzoom_scale;
	}

	public void setMaxzoom_scale(String maxzoom_scale) {
		this.maxzoom_scale = maxzoom_scale;
	}
	
	
}
