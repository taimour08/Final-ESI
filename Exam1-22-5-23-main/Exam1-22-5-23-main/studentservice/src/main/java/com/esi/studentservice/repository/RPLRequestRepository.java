package com.esi.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.studentservice.model.RPLRequest;

public interface RPLRequestRepository extends JpaRepository<RPLRequest, String> {
}
