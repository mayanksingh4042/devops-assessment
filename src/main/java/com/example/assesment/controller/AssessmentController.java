package com.example.assesment.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assesment.domain.Assessment;
import com.example.assesment.domain.MaturityLevel;
import com.example.assesment.service.AssessmentService;
import com.example.assesment.web.AssesmentDTO;
import com.example.assesment.web.AssesmentRequest;
import com.example.assesment.web.AssessmentResponse;

@RestController
@RequestMapping("/v1/assesments")
public class AssessmentController {
	
	private AssessmentService assesmentService;
	
	public AssessmentController(AssessmentService service) {
		 this.assesmentService=service;
	}
	
	 @GetMapping(path = "/{assesmentType}")
	public ResponseEntity<Assessment> getAssesmentByType(@PathVariable @Valid String assesmentType) {

		Assessment assessmemnt = assesmentService.getAssessmentByType(assesmentType);
		if (assessmemnt == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(assessmemnt, HttpStatus.FOUND);
	}
	 
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<AssessmentResponse>  submitAssessment(@RequestBody AssesmentRequest assessmentRequest) {
		 MaturityLevel maturityLevel =assesmentService.submitAssesment(assessmentRequest);		
		AssessmentResponse response = new AssessmentResponse(assessmentRequest.getAsseesseeId(), assessmentRequest.getAssessmentType(), maturityLevel.toString());
		 return new ResponseEntity<>(response,HttpStatus.CREATED);
	 }

}
