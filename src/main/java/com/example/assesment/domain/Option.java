package com.example.assesment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long optionId;
	
	 @ManyToOne
	 @JoinColumn
	 private Question question;
	 
	 @Column
	 private String optionText;
	 
	 @Column
	 private int weightage;
	 
	 @Column
	 private String level;
	 
	
	

}
