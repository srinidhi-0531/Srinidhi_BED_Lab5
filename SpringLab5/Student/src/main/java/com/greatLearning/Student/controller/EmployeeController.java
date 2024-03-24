package com.greatLearning.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.Student.ASLab5.model.Employee;
import com.greatLearning.Student.ASLab5.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeServiceImpl;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Employee e2 = new Employee();
		e2.setId(id);
		e2.setFirstName(firstName);
		e2.setLastName(lastName);
		e2.setEmail(email);

		return employeeServiceImpl.addEmployee(e2);
	}

	@GetMapping("/getEmployee")
	public Employee getEmployee(@RequestParam("id") int id) {
		return employeeServiceImpl.getEmployee(id);
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployee() {
		return employeeServiceImpl.getAllEmployees();
	}

	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		List<Employee> listEmployees = employeeServiceImpl.getAllEmployees();
		theModel.addAttribute("employees", listEmployees);
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee e1 = new Employee();
		theModel.addAttribute("employee", e1);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee ez) {
		employeeServiceImpl.addEmployee(ez);
		return "redirect:/employees/list";
	}

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestParam("empid") int empid, @RequestBody Employee e3) {
		return employeeServiceImpl.updateEmployee(empid, e3);
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empId") int empid, Model theModel) {
		Employee employeedb = employeeServiceImpl.getEmployee(empid);
		theModel.addAttribute("employee", employeedb);
		return "employees/employee-form";
	}

	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeServiceImpl.deleteEmployee(id);
		return "Record Deleted";
	}

	@PostMapping("/delete")
	public String deleteMyEmployee(@RequestParam("empId") int id) {
		employeeServiceImpl.deleteEmployee(id);
		return "redirect:/employees/list";
	}
}