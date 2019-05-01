package com.example.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assesment.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
