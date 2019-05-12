package com.example.assesment.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Assessee {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assesseeId;
	
	@Column
	private String teamName;
	
	@Column
	private String BusinessUnitName;
	
	@OneToMany
	private List<Response> responses;
	
	
	

}
