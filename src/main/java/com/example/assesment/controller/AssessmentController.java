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

import com.example.assesment.service.AssessmentService;
import com.example.assesment.web.AssesmentDTO;
import com.example.assesment.web.AssesmentRequest;

@RestController
@RequestMapping("/v1/assesments")
public class AssessmentController {
	
	private AssessmentService assesmentService;
	
	public AssessmentController(AssessmentService service) {
		 this.assesmentService=service;
	}
	
	 @GetMapping(path = "/{assesmentType}")
	public ResponseEntity<AssesmentDTO> getAssesmentByType(@PathVariable @Valid String assesmentType) {

		AssesmentDTO assessmemnt = assesmentService.getAssessmentByType(assesmentType);
		if (assessmemnt == null) {
			return new ResponseEntity<AssesmentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AssesmentDTO>(assessmemnt, HttpStatus.FOUND);
	}
	 
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Object>  submitAssessment(@RequestBody AssesmentRequest assessmentRequest) {
		 assesmentService.submitAssesment(assessmentRequest);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }

}
