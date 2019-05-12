package com.example.assesment.web;

import java.io.Serializable;
import java.util.Set;

import com.example.assesment.domain.Question;
import com.example.assesment.service.AssesmentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AssesmentDTO implements Serializable{

	private static final long serialVersionUID = 3528697450438428206L;

	private AssesmentType assessmentType;
	
	private Set<Question> questionary;

}
