package com.example.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assesment.domain.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long>{

}
