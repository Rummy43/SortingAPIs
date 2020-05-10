package com.project.SortingAPI.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.SortingAPI.model.Employee;
import com.project.SortingAPI.repository.EmployeeRepository;


@Service
public class SortingService {

	private EmployeeRepository employeeRepository;
	
	public SortingService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}	
}
