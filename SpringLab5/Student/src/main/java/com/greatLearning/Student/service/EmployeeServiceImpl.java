package com.greatLearning.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.Student.ASLab5.model.Employee;
import com.greatLearning.Student.ASLab5.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee e2) {
		return employeeRepository.save(e2);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int empid) {
	    return employeeRepository.findById(empid).get();
	}

	

	@Override
	public Employee updateEmployee(int empid, Employee e3) {
		Employee employeedb =getEmployee(empid);
		
		employeedb.setFirstName(e3.getFirstName());
		employeedb.setLastName(e3.getLastName());
		employeedb.setEmail(e3.getEmail());
		return employeeRepository.save(employeedb);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}

	
}