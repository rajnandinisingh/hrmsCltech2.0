package com.cltech.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.Employee;
import com.cltech.hrms.bean.Experience;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.constant.MessageConstant;
import com.cltech.hrms.constant.Status;
import com.cltech.hrms.repository.EmployeeRepository;
import com.cltech.hrms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseBean saveEmployee(Employee employee) {

		System.out.println(employee);

		if (employee != null) {
			employeeRepository.save(employee);
			return ResponseBean.builder().status(Status.SUCCESS)
					.message(MessageConstant.RECORD_CREATED.formatted(employee.getId())).response(employee).build();
		}

		return ResponseBean.builder().status(Status.FAIL).message(MessageConstant.RECORD_NULL).response(employee)
				.build();
	}

	@Override
	public ResponseBean updateEmployee(Employee employee) {

		if (employee != null) {

			employeeRepository.save(employee);
			return ResponseBean.builder().status(Status.SUCCESS).message(MessageConstant.RECORD_CREATED)
					.response(employee).build();
		}
		return ResponseBean.builder().status(Status.FAIL).message(MessageConstant.RECORD_NULL).response(employee)
				.build();
	}

	@Override
	public ResponseBean getAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		System.out.println(employees);
		return ResponseBean.builder().status(Status.SUCCESS).message(MessageConstant.ALL_RECORD).response(employees)
				.build();
	}

	@Override
	public ResponseBean getEmployeeById(Long id) {

		Employee employee = employeeRepository.findById(id).get();

		return ResponseBean.builder().status(Status.SUCCESS)
				.message(MessageConstant.ALL_RECORD.formatted(employee.getId())).response(employee).build();
	}

	@Override
	public ResponseBean getEmployeeByEducation(Education education) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean getEmployeeByEducation(Long educationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean getEmployeeByExperience(Experience experience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean getEmployeeByExperience(Long experienceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
