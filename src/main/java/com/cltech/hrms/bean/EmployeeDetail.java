package com.cltech.hrms.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

@Entity
@Table
@Embeddable
@Data
public class EmployeeDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Address addresses;

	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String alternateEmail;
	@Column
	private String phone;
	@Column
	private String alternatePhone;
	@Column
	private String DOB;

}
