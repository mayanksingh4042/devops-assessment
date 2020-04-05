package com.example.assesment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;

import com.example.assesment.domain.Assessment;
import com.example.assesment.domain.Assessee;
import com.example.assesment.domain.Option;
import com.example.assesment.domain.Question;
import com.example.assesment.repository.AssesseeRepository;
import com.example.assesment.repository.AssessmentRepository;
import com.example.assesment.service.AssesmentType;
import com.example.assesment.service.AssessmentService;
import com.example.assesment.web.AssesmentRequest;

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
		
		Assessment assessment = new Assessment();
		assessment.setAssesmentType(AssesmentType.DEVOPS);
		AssessmentRepository assessmentRepository = applicationContext.getBean(AssessmentRepository.class);
		
		Assessment cloudassessment = new Assessment();
		
		cloudassessment.setAssesmentType(AssesmentType.CLOUD);
		//assessmentRepository.save(assessment);
		assessmentRepository.save(cloudassessment);
		Assessee assessee = new Assessee();
		assessee.setBusinessUnitName("Finance");
		assessee.setTeamName("Project1");
		AssesseeRepository assesseeRepository = applicationContext.getBean(AssesseeRepository.class);
		assesseeRepository.save(assessee);
		Question question1 = new Question();
		question1.setAssessment(assessment);
		question1.setQuestionText("How frequently do you release to production");
		List<Option> responses = new ArrayList<>();
		Option option1 = new Option();
		option1.setOptionText("multiple times in a day");
		option1.setWeightage(50);
		option1.setQuestion(question1);
		Option option2 = new Option();
		option2.setOptionText("daily");
		option2.setQuestion(question1);
		option2.setWeightage(40);
		Option option3 = new Option();
		option3.setQuestion(question1);
		option3.setOptionText("weekly");
		option3.setWeightage(30);
		Option option4 = new Option();
		option4.setQuestion(question1);
		option4.setOptionText("bi weekly");
		option4.setWeightage(20);
		Option option5 = new Option();
		option5.setQuestion(question1);
		option5.setOptionText("monthly");
		option5.setWeightage(10);
		option5.setQuestion(question1);
		responses.add(option1);
		responses.add(option2);
		responses.add(option3);
		responses.add(option4);
		responses.add(option5);
		
		question1.setResponses(responses);
		
		Question question2 = new Question();
		question2.setAssessment(assessment);
		question2.setQuestionText("what is your development methedology");
		 responses = new ArrayList<>();
		 option1 = new Option();
		option1.setOptionText("sofisticted scrum teams");
		option1.setWeightage(50);
		option1.setQuestion(question2);
		 option2 = new Option();
		option2.setOptionText("scrum");
		option2.setQuestion(question2);
		option2.setWeightage(40);
		 option3 = new Option();
		option3.setQuestion(question2);
		option3.setOptionText("waterfall and scrum");
		option3.setWeightage(30);
		 option4 = new Option();
		option4.setQuestion(question2);
		option4.setOptionText("waterfall");
		option4.setWeightage(20);
		 option5 = new Option();
		option5.setQuestion(question2);
		option5.setOptionText("No dev methedology");
		option5.setWeightage(10);
		option5.setQuestion(question2);
		responses.add(option1);
		responses.add(option2);
		responses.add(option3);
		responses.add(option4);
		responses.add(option5);
		
		question2.setResponses(responses);
		
		Question question3 = new Question();
		question3.setAssessment(assessment);
		question3.setQuestionText("how you deploy your builds");
		 responses = new ArrayList<>();
		 option1 = new Option();
		option1.setOptionText("fully automated CI CD pielines");
		option1.setWeightage(50);
		option1.setQuestion(question3);
		 option2 = new Option();
		option2.setOptionText("Fully automated CI and parually automated CD");
		option2.setQuestion(question3);
		option2.setWeightage(40);
		 option3 = new Option();
		option3.setQuestion(question3);
		option3.setOptionText("somwwhat automated CI and fully manual CD");
		option3.setWeightage(30);
		 option4 = new Option();
		option4.setQuestion(question3);
		option4.setOptionText("manual CI");
		option4.setWeightage(20);
		 option5 = new Option();
		option5.setQuestion(question3);
		option5.setOptionText("No CI CD");
		option5.setWeightage(10);
		option5.setQuestion(question3);
		responses.add(option1);
		responses.add(option2);
		responses.add(option3);
		responses.add(option4);
		responses.add(option5);
		
		question3.setResponses(responses);
		List<Question> questions = new ArrayList<>();
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		
		assessment.setQuestions(questions);
		assessmentRepository.save(assessment);
		
		AssessmentService assessmentService = applicationContext.getBean(AssessmentService.class);
		Map<Long,List<Long>>assesmentResponseMap = new HashMap<>();
		List<Long> optionIdList1 =new ArrayList();
		optionIdList1.add(question1.getResponses().get(1).getOptionId());
		List<Long> optionIdList2 =new ArrayList();
		optionIdList1.add(question2.getResponses().get(1).getOptionId());
		List<Long> optionIdList3 =new ArrayList();
		optionIdList1.add(question3.getResponses().get(1).getOptionId());
		assesmentResponseMap.put(question1.getQuestionId(),optionIdList1);
		assesmentResponseMap.put(question2.getQuestionId(),optionIdList2);
		assesmentResponseMap.put(question3.getQuestionId(), optionIdList3);
		AssesmentRequest assessmentRequest = new AssesmentRequest(assesmentResponseMap, assessee.getAssesseeId(), AssesmentType.DEVOPS.name());
		assessmentService.submitAssesment(assessmentRequest);
		
		
		
		
		
		
	   
	}

}
