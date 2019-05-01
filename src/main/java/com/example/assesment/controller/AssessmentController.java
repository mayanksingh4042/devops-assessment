package com.example.assesment.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assesment.service.AssessmentService;
import com.example.assesment.web.AssesmentDTO;

@RestController
@RequestMapping("/v1/assesments")
public class AssessmentController {
	
	private AssessmentService assesmentService;
	
	public AssessmentController(AssessmentService service) {
		 this.assesmentService=service;
	}
	
	public ResponseEntity<AssesmentDTO> getAssesmentByType(@Valid String assesmentType){
		
		AssesmentDTO assessmemnt = assesmentService.getAssessmentByType(assesmentType);
		if(assessmemnt==null) {
			return new ResponseEntity<AssesmentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AssesmentDTO>(assessmemnt, HttpStatus.FOUND);
		
	
	}

}
