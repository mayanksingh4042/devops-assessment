package com.example.assesment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;

import com.example.assesment.domain.Assesment;
import com.example.assesment.domain.Question;
import com.example.assesment.repository.AssessmentRepository;
import com.example.assesment.service.AssesmentType;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@PropertySource("classpath:application.properties")
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
@PropertySource("classpath:application.properties")
public class SurveyApplication {
	
	@Autowired
	private  ApplicationContext applicationContext;

	public static void main(String[] args) {
		 SpringApplication.run(SurveyApplication.class, args);
	}
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void addAssesmentData() {
		
		Assesment assessment = new Assesment();
		assessment.setAssesmentType(AssesmentType.DEVOPS);
		AssessmentRepository assessmentRepository = applicationContext.getBean(AssessmentRepository.class);
		assessmentRepository.save(assessment);
		Assesment cloudassessment = new Assesment();
		cloudassessment.setAssesmentType(AssesmentType.CLOUD);
		
		
	   
	}

}
