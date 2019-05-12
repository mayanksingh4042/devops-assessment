package com.example.assesment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.assesment.domain.Assessee;
import com.example.assesment.domain.Assessment;
import com.example.assesment.domain.MaturityLevel;
import com.example.assesment.domain.Response;
import com.example.assesment.domain.ResponseOptions;
import com.example.assesment.repository.AssessmentRepository;
import com.example.assesment.repository.OptionRepository;
import com.example.assesment.repository.ResponseRepository;
import com.example.assesment.web.AssesmentRequest;

@Component
public class AssessmentService {
	
	private OptionRepository optionRepository;
	
	private ResponseRepository responseRepository;
	
	private MaturityLevelCalculator  maturityLevelCalculator;
	
	private AssessmentRepository assessmentRepository;
	
	public AssessmentService(OptionRepository optionRepository,MaturityLevelCalculator  maturityLevelCalculator,ResponseRepository responseRepository,AssessmentRepository assessmentRepository) {
		this.optionRepository=optionRepository;
		this.maturityLevelCalculator=maturityLevelCalculator;
		this.responseRepository=responseRepository;
		this.assessmentRepository=assessmentRepository;
	}
	
	 

	public Assessment getAssessmentByType(String assesmentType) {
		return assessmentRepository.getByAssesmentType(assesmentType);
	}

	public MaturityLevel submitAssesment(AssesmentRequest assessmentRequest) {
		List<Long> selectedOptions = assessmentRequest
				.getAssesmentResponseMap()
				.values()
				.stream()
				.flatMap(e->e.stream())
				.collect(Collectors.toList());
		
	 	Double finalWeighatge =optionRepository.getWeightageByOptionIdIn(selectedOptions).stream().mapToInt(e->e.getWeightage()).average().getAsDouble();
	    Response response = new Response();
	    Assessee assessee = new Assessee();
	    assessee.setAssesseeId(assessmentRequest.getAsseesseeId());
	    response.setAssessee(assessee);
	  
		MaturityLevel maturityLevel = maturityLevelCalculator.calculateMaturityLevel(finalWeighatge.intValue(),AssesmentType.valueOf(assessmentRequest.getAssessmentType()));
	    response.setMaturityLevel(maturityLevel);
	    for(Long question:assessmentRequest.getAssesmentResponseMap().keySet()) {
	    for(Long option:assessmentRequest.getAssesmentResponseMap().get(question)) {
	    	ResponseOptions responseOption = new ResponseOptions();
	    	responseOption.setOption(option);
	    	responseOption.setQuestion(question);
	    	responseOption.setResponse(response.getResponseId());
	    }
	    }
	    
	    responseRepository.save(response);
	    return maturityLevel;
	 	
	 	
		
		
	}
	
	

}
