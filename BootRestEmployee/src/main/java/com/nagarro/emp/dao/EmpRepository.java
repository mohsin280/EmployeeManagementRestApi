package com.nagarro.emp.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.emp.entitie.Employee;

public interface EmpRepository extends CrudRepository<Employee, Integer>{
	public Employee findByEmpCode(int empCode);
}
