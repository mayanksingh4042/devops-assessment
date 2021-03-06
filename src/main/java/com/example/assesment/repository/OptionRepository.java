package com.example.assesment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assesment.domain.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long>{

	List<WeightageOnly> getWeightageByOptionIdIn(List<Long> selectedOptions);

}

 
