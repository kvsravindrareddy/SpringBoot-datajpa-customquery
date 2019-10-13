package com.ravindra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravindra.request.EmployeeData;
import com.ravindra.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/emp")
	public void saveEmpData(@RequestBody EmployeeData employeeData)
	{
		employeeService.saveEmpData(employeeData);
	}
	
	@GetMapping(value="/emp")
	public EmployeeData getEmpData(@RequestParam String empId)
	{
		return employeeService.getEmpData(empId);
	}
	
	@DeleteMapping(value="/emp")
	public void deleteEmpData(@RequestParam String empId)
	{
		employeeService.delelteEmpData(empId);
	}
	
	@PutMapping(value="/emp")
	public void updateEmpData(@RequestBody EmployeeData employeeData)
	{
		employeeService.updateEmpData(employeeData);
	}
	
	@PutMapping(value="/empupdate")
	public void updateEmpDatanew(@RequestBody EmployeeData employeeData, @RequestParam String empId)
	{
		employeeService.updateEmpDatanew(employeeData, empId);
	}
	
	@GetMapping(value="/emps")
	public Iterable<EmployeeData> getEmpS()
	{
		return employeeService.getEmps();
	}
}