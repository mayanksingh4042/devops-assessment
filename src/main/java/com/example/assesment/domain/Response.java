package com.example.assesment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long responseId;
	
	@OneToOne
	private Assessee assessee;
	
	@Enumerated(javax.persistence.EnumType.STRING)
	private MaturityLevel maturityLevel;

}
