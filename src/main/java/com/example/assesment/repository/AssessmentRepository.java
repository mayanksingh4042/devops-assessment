package com.example.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assesment.domain.Assesment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assesment, Long>{

}
