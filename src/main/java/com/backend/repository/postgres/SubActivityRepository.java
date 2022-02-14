package com.backend.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.subActivities;

public interface SubActivityRepository extends JpaRepository<subActivities, Long>{

}
