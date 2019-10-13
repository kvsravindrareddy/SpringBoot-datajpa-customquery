package com.ravindra.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ravindra.request.EmployeeData;

@Repository
public interface EmployeeRepo extends CrudRepository<EmployeeData, Long>{
	@Query("select new EMP_DATA_TB(emp.empId, emp.empName, emp.salary) from EMP_DATA_TB emp where emp.empId= :empId")
	EmployeeData findByEmpId(@Param("empId")String empId);
	
	@Transactional
	@Modifying
	@Query("delete from EMP_DATA_TB where empId=:empId")
	void deleteByEmpId(@Param("empId")String empId);
	
	boolean existsByEmpId(String empId);
	
	@Query("select new EMP_DATA_TB(emp.empId, emp.empName, emp.salary) from EMP_DATA_TB emp")
	Iterable<EmployeeData> findAll();
}