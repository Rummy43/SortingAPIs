package com.project.SortingAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.project.SortingAPI.Service.SortingService;
import com.project.SortingAPI.model.Employee;
import com.project.SortingAPI.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SortingServiceTest {
	
	@MockBean(name="employeeRepository")
	private EmployeeRepository employeeRepository;

	@Test
	void getAllEmployees() {
		Employee employeeSample = new Employee("Rummy",25, "IT");
		employeeRepository.save(employeeSample);

		System.out.println(employeeRepository.findAll());
		
		SortingService sortingService = new SortingService(employeeRepository);
		
		List<Employee> employeeList = sortingService.findAll();
		Employee  lastEmplpoyee = employeeList.get(0);
		
		assertEquals(employeeSample.getName(), lastEmplpoyee.getName());
		assertEquals(employeeSample.getId(), lastEmplpoyee.getId());
		assertEquals(employeeSample.getDept(), lastEmplpoyee.getDept());
		assertEquals(employeeSample.getAge(), lastEmplpoyee.getAge());
		
	}
}
