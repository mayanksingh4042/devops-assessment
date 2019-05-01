package com.example.assesment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assessee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assesseeId;
	
	@Column
	private String teamName;
	
	@Column
	private String BusinessUnitName;
	
	
	

}
