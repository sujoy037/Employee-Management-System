package net.javaguides.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController{
	
	@Autowired
	private EmployeeService employeeService;
	
	//Build Api Add Employee
	@PostMapping
	public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto saveEmployee=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(saveEmployee,HttpStatus.CREATED);
		
	}
	//Build Api find by id employee
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//Build Api Get all Employees
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		List<EmployeeDto>employees= employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}
	
	//Bulid employee update Api
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable("id")Long employeeId,
			@RequestBody EmployeeDto updateEmployee){
		EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updateEmployee);
		return ResponseEntity.ok(employeeDto);
		
	}
	
	//Build delete employee id
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable("id")Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("delete successfully");
	}

}
