package com.ravindra.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravindra.repo.EmployeeRepo;
import com.ravindra.request.EmployeeData;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public void saveEmpData(EmployeeData employeeData) {
		employeeRepo.save(employeeData);
	}

	public EmployeeData getEmpData(String empId) {
		return employeeRepo.findByEmpId(empId);
	}

	@Transactional
	public void delelteEmpData(String empId) {
		employeeRepo.deleteByEmpId(empId);
	}

	public void updateEmpData(EmployeeData employeeData) {
		employeeRepo.save(employeeData);
	}

	public void updateEmpDatanew(EmployeeData employeeData, String empId) {
		
		if(employeeRepo.existsByEmpId(empId))
		{
			employeeData.setId(employeeRepo.findByEmpId(empId).getId());
			employeeData.setEmpId(employeeData.getEmpId());
			employeeData.setEmpName(employeeData.getEmpName());
			employeeData.setSalary(employeeData.getSalary());
			employeeRepo.save(employeeData);
		}
		else
		{
			employeeRepo.save(employeeData);
		}
	}

	public Iterable<EmployeeData> getEmps() {
		return employeeRepo.findAll();
	}
}