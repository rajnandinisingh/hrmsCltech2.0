package com.cltech.hrms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String jobTitle;
	@Column
	private String jobDescription;
	@Column
	private String organizationName;
	@Column
	private String startDate;
	@Column
	private String endDate;
	@Column
	private double currentlyWorking;
}
