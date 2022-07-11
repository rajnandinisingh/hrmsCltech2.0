package com.cltech.hrms.bean;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String addressLine;
	@Column
	private String country;
	@Column
	private String state;
	@Column
	private String city;
	@Column
	private String pincode;
//	@Column
//	private long fk_employeeDetail_id;
//	@Column
//	private long fk_employee_id;
}
