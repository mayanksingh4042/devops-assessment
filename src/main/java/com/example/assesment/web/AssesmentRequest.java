package com.example.assesment.web;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AssesmentRequest {
	
	
    
	private Map<Long,List<Long>> assesmentResponseMap;
	
	private  Long asseesseeId;
	
	private  String assessmentType;
	
	

}
