package net.javaguides.ems.service;

import java.util.List;

import net.javaguides.ems.dto.EmployeeDto;


public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto>getAllEmployee();
	
	EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee);
	
	void deleteEmployee(Long employeeId);
}
