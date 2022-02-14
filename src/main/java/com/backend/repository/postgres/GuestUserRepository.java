package com.backend.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.guestUser;

@Repository
public interface GuestUserRepository extends JpaRepository<guestUser, Long>{

}
