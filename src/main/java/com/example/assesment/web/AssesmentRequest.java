package com.example.assesment.web;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AssesmentRequest {
    
	private Map<Long,List<Long>> assesmentResponseMap;
	
	private  Long asseesseeId;
	
	private  String assessmentType;
	



}
