package com.greatLearning.Student.service;

import java.util.List;

import com.greatLearning.Student.ASLab5.model.Employee;


public interface EmployeeService {

	
	Employee addEmployee(Employee e2);

	List<Employee> getAllEmployees();

	Employee getEmployee(int empid);

	Employee updateEmployee(int empid, Employee e3);

	void deleteEmployee(int id);

}