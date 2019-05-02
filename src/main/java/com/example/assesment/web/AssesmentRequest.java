package com.example.assesment.web;

import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public class AssesmentRequest {
	
	
	private String projectId;
	
	private String businessUnitName;
	
	private Map<Long,List<Long>> assesmentResponseMap;
	
	public AssesmentRequest(String projectId,String businessUnitName,Map<Long,List<Long>> assesmentResponseMap) {
		this.projectId=projectId;
		this.businessUnitName=businessUnitName;
		this.assesmentResponseMap=assesmentResponseMap;
	}

}
