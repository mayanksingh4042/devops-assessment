package com.example.assesment.web;

import java.util.List;
import java.util.Map;

import com.example.assesment.domain.Assessee;

import lombok.Getter;

@Getter
public class AssesmentRequest {
	
	
	private Assessee assessee;
	
	private Map<Long,List<Long>> assesmentResponseMap;
	
	public AssesmentRequest(Assessee assessee ,Map<Long,List<Long>> assesmentResponseMap) {
	
		this.assesmentResponseMap=assesmentResponseMap;
		this.assessee=assessee;
	}

}
