package com.cltech.hrms.bean;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table
@Data
public class Employee {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column
	@Pattern(regexp = "^[a-zA-Z\s]*$")
	String carrierObjective; // allowed character 256 or 512

	@OneToOne(cascade = CascadeType.ALL)
	EmployeeDetail employeeDetail;

	@OneToMany(cascade = CascadeType.ALL)
	List<Skills> skills;

	@OneToMany(cascade = CascadeType.ALL)
	List<Experience> experiences;

	@OneToMany(cascade = CascadeType.ALL)
	List<Education> educations;

	@OneToMany(cascade = CascadeType.ALL)
	List<Project> projects;

	@OneToMany(cascade = CascadeType.ALL)
	List<Language> languages;

	@Column
	boolean working;

	@Column
	double currentCTC;

	@Column
	double expectedCTC;

	@Column
	@Pattern(regexp = "^[a-zA-Z\s]*$")
	String preferrredLocation; // optional

	@ElementCollection
	List<String> certifications;

	@ElementCollection
	List<String> hobbies;

//	@ElementCollection
//	List<String> accomplishments;

	@OneToMany(cascade = CascadeType.ALL)
	List<SocialMedialLinks> socialMediaLinks;

}
