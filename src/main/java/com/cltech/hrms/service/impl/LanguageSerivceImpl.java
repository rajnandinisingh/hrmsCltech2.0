package com.cltech.hrms.service.impl;

import org.springframework.stereotype.Service;

import com.cltech.hrms.bean.Language;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.constant.Status;
import com.cltech.hrms.repository.LanguageRepository;
import com.cltech.hrms.service.PropertyService;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class LanguageSerivceImpl {

	@Autowired
	@Qualifier("propertyServiceImpl")
	protected PropertyService propertyService;

	private static Logger LOGGER = LogManager.getLogger(LanguageSerivceImpl.class);

	@Autowired
	private LanguageRepository languageRepo;

	public ResponseBean addLanguage(Language lan) {

		try {
			if (lan == null) {
				return ResponseBean.builder().status(Status.FAIL).message("Kindly Provide the Language Details")
						.build();
			}

			Language languageBean = languageRepo.save(lan);
			return ResponseBean.builder().status(Status.SUCCESS).message("Record Added Successfully")
					.response(languageBean).build();

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}

	}

	public ResponseBean updateLanguage(Language lan) {
		try {
			if (lan == null) {
				return ResponseBean.builder().status(Status.FAIL).message("null").build();
			}
			if (lan.getId() > 0) {

				Optional<Language> findById = languageRepo.findById((int) lan.getId());
				if (findById != null) {
					Language languageBean = languageRepo.save(findById.get());
					return ResponseBean.builder().status(Status.SUCCESS).message("Record updated Successfully")
							.response(languageBean).build();
				}
			} else {
				return ResponseBean.builder().status(Status.FAIL).message("please provide id").build();

			}

			return ResponseBean.builder().status(Status.FAIL).message("Record Not Found").build();

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}

	}

	public ResponseBean deleteById(int id) {
		try {
			languageRepo.deleteById(id);
			return ResponseBean.builder().status(Status.SUCCESS).message("Deleted Successfully").build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}

	public ResponseBean getAllLanguageDetails() {
		List<Language> list = languageRepo.findAll();
		try {
			if (list.size() <= 0) {
				return ResponseBean.builder().status(Status.FAIL).message("Data is Null").build();
			} else {
				return ResponseBean.builder().status(Status.SUCCESS).message("This is the List of EdcuationDetails")
						.response(list).build();
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}

	public ResponseBean getById(int id) {
		Language lan = languageRepo.findById(id).get();
		try {
			if (lan == null) {
				return ResponseBean.builder().status(Status.FAIL).message("No Data Found").build();
			} else {
				return ResponseBean.builder().status(Status.SUCCESS)
						.message("This is the data which found from Databases").response(lan).build();
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}

	}
}
