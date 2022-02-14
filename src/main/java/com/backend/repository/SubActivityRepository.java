package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.subActivities;

@Repository
public interface SubActivityRepository extends JpaRepository<subActivities, Long>{

}
