package com.cltech.hrms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.Employee;
import com.cltech.hrms.bean.Experience;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.constant.MessageConstant;
import com.cltech.hrms.constant.Status;
import com.cltech.hrms.service.EmployeeService;
import com.cltech.hrms.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping(path = "SaveEmployeeCommand")
	public ResponseBean saveEmployee(@RequestBody @Valid Employee employee) {

		if (employee != null) {
			employeeService.saveEmployee(employee);
			return ResponseBean.builder().status(Status.SUCCESS).message(MessageConstant.RECORD_CREATED)
					.response(employee).build();
		}

		return ResponseBean.builder().status(Status.FAIL).message(MessageConstant.RECORD_NULL).response(employee)
				.build();
	}

	public ResponseBean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping(path = "/AllEmployeeCommand")
	public ResponseBean getAllEmployee() {

		return employeeService.getAllEmployee();

	}

	public ResponseBean getEmployeeById(Long id) {

		return null;
	}

	public ResponseBean getEmployeeByEducation(Education education) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseBean getEmployeeByEducation(Long educationId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseBean getEmployeeByExperience(Experience experience) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseBean getEmployeeByExperience(Long experienceId) {
		// TODO Auto-generated method stub
		return null;
	}
}
