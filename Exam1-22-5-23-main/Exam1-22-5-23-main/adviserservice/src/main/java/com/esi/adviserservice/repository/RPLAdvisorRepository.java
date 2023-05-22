package com.esi.adviserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.adviserservice.model.RPLAdvisor;

public interface RPLAdvisorRepository extends JpaRepository<RPLAdvisor, String> {
}
