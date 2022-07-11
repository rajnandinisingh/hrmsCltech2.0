package com.cltech.hrms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Data
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String languageName;

	private String proficient;

	@Column(name = "readv")
	private boolean read;

	@Column(name = "speakv")
	private boolean speak;

	@Column(name = "writev")
	private boolean write;
}
