package com.example.assesment.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long responseId;
	
	 @ManyToOne
	 @JoinColumn
	 @JsonBackReference
	private Assessee assessee;
	
	@Enumerated(javax.persistence.EnumType.STRING)
	private MaturityLevel maturityLevel;
	
	@OneToMany( fetch = FetchType.EAGER ,mappedBy = "question", cascade = CascadeType.ALL)
	 @JsonManagedReference
	private List<ResponseOptions> responseOption;

}
