package com.cltech.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cltech.hrms.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
