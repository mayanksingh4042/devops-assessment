package com.example.assesment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ResponseOptions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long responseOptionId;
	
	
	 @ManyToOne
	 @JoinColumn
	 private Response response;
	
	 @ManyToOne
	 @JoinColumn
	 private Question question;
	 
	 @ManyToOne
	 @JoinColumn
	 private Option option;
	
	

}
