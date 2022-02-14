package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.kmlFile;

@Repository
public interface KmlFileRepository extends JpaRepository<kmlFile, Long>{

}
