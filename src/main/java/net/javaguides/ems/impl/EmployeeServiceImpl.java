package net.javaguides.ems.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee=EmployeeMapper.toMapEmployee(employeeDto);
		Employee saveEmployee=employeeRepository.save(employee);	
		return EmployeeMapper.toMapEmployeeDto(saveEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee=employeeRepository.findById(employeeId)
			.orElseThrow(()->new ResourceNotFoundException("Employee not exits with given id:" + employeeId));
		return EmployeeMapper.toMapEmployeeDto(employee); 
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee>employees= employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.toMapEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
		Employee employee=employeeRepository.findById(employeeId)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exits with given id:" + employeeId));
		
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());
		
		Employee updateEmployeeObj= employeeRepository.save(employee);
		
		
		
		return EmployeeMapper.toMapEmployeeDto(updateEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee=employeeRepository.findById(employeeId)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exits with given id:" + employeeId));
		
		employeeRepository.deleteById(employeeId);
		
	}

}
