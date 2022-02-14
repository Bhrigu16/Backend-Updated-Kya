package com.backend.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.activities;

public interface ActivityRepository extends JpaRepository<activities, Long>{

}
