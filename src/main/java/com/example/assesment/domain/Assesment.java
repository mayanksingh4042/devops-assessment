package com.example.assesment.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.assesment.service.AssesmentType;

@Entity
public class Assesment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assessmentId;
	
	@Enumerated(javax.persistence.EnumType.STRING)
	private AssesmentType assesmentType;
	
	@OneToMany(mappedBy = "assesment", cascade = CascadeType.ALL)
    private Set<Question> questions;
	
	
	

}
