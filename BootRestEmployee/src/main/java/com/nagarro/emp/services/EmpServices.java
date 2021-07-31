package com.nagarro.emp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.emp.dao.EmpRepository;
import com.nagarro.emp.entitie.Employee;

@Component
public class EmpServices {

	@Autowired
	private EmpRepository empRepository;
	
	public List<Employee> getAllEmps(){
		List<Employee> employees = (List<Employee>) empRepository.findAll();
		return employees;
	}
	
	public Employee getEmpById(int empCode) {
		Employee employee = empRepository.findByEmpCode(empCode);
		return employee;
	}
	
	public Employee addEmp(Employee employee) {
		Employee result =  empRepository.save(employee);
		return result;
	}
	
	public void deleteEmpById(int empCode) {
		empRepository.deleteById(empCode);
	}
	
	public void updateEmpById(Employee employee,int empCode) {
		employee.setEmpCode(empCode);
		empRepository.save(employee);
	}
}
