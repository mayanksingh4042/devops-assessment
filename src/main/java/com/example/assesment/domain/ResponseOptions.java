package com.example.assesment.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ResponseOptions {
	
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
