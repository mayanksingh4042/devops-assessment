package com.example.assesment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ResponseOptions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long responseOptionId;
	
	
	
	 private Long response;
	
	
	 private Long question;
	 
	
	 private Long option;
	
	

}
