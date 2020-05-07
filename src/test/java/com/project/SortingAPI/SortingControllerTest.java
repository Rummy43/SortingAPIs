package com.project.SortingAPI;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.project.SortingAPI.Service.SortingService;
import com.project.SortingAPI.model.Employee;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class SortingControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	SortingService sortingService;
	
	@Test
	void getAllEmployees() throws Exception{
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(1L,"Rummy",25,"IT"));
		employeeList.add(new Employee(2L,"Swathi",30,"EEE"));
		employeeList.add(new Employee(3L,"Madhuri",31,"ECE"));
		employeeList.add(new Employee(4L,"Anu",32,"ECE"));
		employeeList.add(new Employee(5L,"Neelima",33,"CSE"));
		employeeList.add(new Employee(6L,"Sirisha",35,"CSE"));
		
		when(sortingService.findAll()).thenReturn(employeeList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/employees").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(6))).andDo(print());
		
	}
}
