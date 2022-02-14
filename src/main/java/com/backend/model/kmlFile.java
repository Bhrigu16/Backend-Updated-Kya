package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.opengis.geometry.Geometry;
import org.opengis.geometry.coordinate.Polygon;

import lombok.Data;


@Data
@Entity
@Table(name="kml_file")
public class kmlFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gid_kml;
	
	@Column(nullable = false,columnDefinition = "Geometry")
	private org.locationtech.jts.geom.Geometry geom;
	
	//Foreign Key
	@Column(nullable = false)
	private Long activity_id;
	
	//Foreign Key
	@Column(nullable = false)
	private Long sub_activity_name;
	
	@Column(nullable = false)
	private String kmlfile_name;

	@Column(nullable = false)
	private byte[] file_kml;

	

}
