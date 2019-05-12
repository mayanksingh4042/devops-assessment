package com.example.assesment.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "responses")
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	
	
	 @ManyToOne
	 @JsonBackReference
	 @JoinColumn(name="assessment_id")
	 private Assessment assessment;
	 
	 @Column
	 private String questionText;
	 
	 
	 @OneToMany( fetch = FetchType.EAGER ,mappedBy = "question", cascade = CascadeType.ALL)
	 @JsonManagedReference
	 private List<Option> responses;
	 
	 @Override
	 public String toString() {
		 return this.questionId+ "  "+this.questionText;
	 }
	 
	 

}
