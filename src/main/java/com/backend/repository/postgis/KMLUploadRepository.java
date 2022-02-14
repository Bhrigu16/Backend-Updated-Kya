package com.backend.repository.postgis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.kmlFile;

@Repository
public interface KMLUploadRepository extends JpaRepository<kmlFile, Long> {

	//int findById(Long gid_kml);

}
