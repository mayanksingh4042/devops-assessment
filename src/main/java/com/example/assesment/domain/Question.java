package com.example.assesment.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "responses")
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	
	
	 @ManyToOne
	 @JoinColumn
	 private Assesment assessment;
	 
	 @Column
	 private String questionText;
	 
	 @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	 private Set<Option> responses;
	 
	 

}
