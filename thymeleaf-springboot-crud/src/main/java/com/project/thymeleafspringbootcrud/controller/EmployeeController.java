package com.project.thymeleafspringbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.thymeleafspringbootcrud.entity.Employee;
import com.project.thymeleafspringbootcrud.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//Display list of Employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listOfEmployees", employeeService.getEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		//create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//Save Employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	
	@GetMapping("/showUpdateEmployeeForm/{id}")
	public String updateEmployee(@PathVariable (value="id") Long id,Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value="id") Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
