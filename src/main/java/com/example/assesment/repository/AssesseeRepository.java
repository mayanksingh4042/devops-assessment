package com.example.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assesment.domain.Assessee;

@Repository
public interface AssesseeRepository extends JpaRepository<Assessee, Long>{

}
