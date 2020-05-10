package com.project.SortingAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.SortingAPI.Service.SortingService;
import com.project.SortingAPI.model.Employee;

@Controller
public class SortingController {
	
	@Autowired
	private SortingService sortingService;

	@GetMapping("/employees")
	ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<>(sortingService.findAll(), HttpStatus.OK);
	}
	
}
