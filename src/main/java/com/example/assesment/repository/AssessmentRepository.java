package com.example.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assesment.domain.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long>{

	Assessment getByAssesmentType(String assesmentType);

}
