package com.example.assesment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;
	
	 @ManyToOne
	 @JoinColumn
	 @JsonBackReference
	 private Question question;
	 
	 @Column
	 private String optionText;
	 
	 @Column
	 private Integer weightage;
	 
	 @Column
	 private String level;
	 
	 @Override
	 public String toString() {
		 return this.level;
	 }
	 
	
	

}
