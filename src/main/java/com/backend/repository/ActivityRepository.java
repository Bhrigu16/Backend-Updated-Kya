package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.activities;


public interface ActivityRepository extends JpaRepository<activities, Long>{

}
