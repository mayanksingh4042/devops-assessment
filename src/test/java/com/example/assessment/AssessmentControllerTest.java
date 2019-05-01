package com.example.assessment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AssessmentControllerTest {
	
	private MockMvc mockMvc;

	

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void prepareMockMvc() throws Exception {
		this.mockMvc = webAppContextSetup(this.webApplicationContext).build();

	}
	
	@Test
	public void when_a_survey_is_selected_by_type_then_survey_questions_and_options_are_reurned_as_response() throws Exception {
		String assesmentType="DEVOPS";
		this.mockMvc.perform(get("/v1/assesments/" + assesmentType)).andExpect(status().isOk());
		
		
	}
	
	
}
