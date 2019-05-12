package com.example.assesment.web;

import java.util.List;
import java.util.Map;


import lombok.AllArgsConstructor;

import com.example.assesment.domain.Assessee;


import lombok.Getter;

@Getter
@AllArgsConstructor
public class AssesmentRequest {
	
	

    
	private Map<Long,List<Long>> assesmentResponseMap;
	
	private  Long asseesseeId;
	
	private  String assessmentType;
	
	private Assessee assessee;

	
	

	public AssesmentRequest(Assessee assessee ,Map<Long,List<Long>> assesmentResponseMap) {
	
		this.assesmentResponseMap=assesmentResponseMap;
		this.assessee=assessee;
	}


}
