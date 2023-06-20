package com.project.thymeleafspringbootcrud.service;

import java.util.List;

import com.project.thymeleafspringbootcrud.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee employee);
	
	public Employee getEmployeeById(Long id);
	
	public void deleteEmployeeById(Long id);
}
