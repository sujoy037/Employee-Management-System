package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

public class EmployeeMapper {
	//convert User JPA entity into EmployeeDto
	public static EmployeeDto toMapEmployeeDto(Employee employee) {
		EmployeeDto  employeeDto= new EmployeeDto(
				employee.getId(),employee.getFirstName(),employee.getLastName()
				,employee.getEmail()				
				);
		return employeeDto;
	}
	//convert EmployeeDto into User Jpa
	public static Employee toMapEmployee(EmployeeDto employeeDto) {
		Employee employee=new Employee(
				employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName()
				,employeeDto.getEmail()
				);
		return employee;
	}

}
