package com.cltech.hrms.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String schoolName;
	@Column
	private String completionDate;
	@Column
	private String passingPercentage;

//	private String degree;
//
//	private String fieldOfStudy;
//
//	private String location;
//
//	private String university;
//
//	private Double passingPercentage;
//
//	private Date completionDate;

}
