package com.example.assesment.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.assesment.service.AssesmentType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "questions")
@Entity
public class Assesment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9181507825891402201L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assessmentId;
	
	
	@Enumerated(EnumType.STRING)
	private AssesmentType assesmentType;
	
	@OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL)
    private Set<Question> questions;
	
	
	

}
