package com.nagarro.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.emp.entitie.Employee;
import com.nagarro.emp.services.EmpServices;

@RestController
public class EmpController {
	
	@Autowired
	private EmpServices empServices;
	
	@GetMapping("/employees/getAll")
	public ResponseEntity<List<Employee>> getEmps(){
		List<Employee> employees = empServices.getAllEmps();
		if(employees.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(employees);
	}
	
	@GetMapping("/employees/get/{id}")
	public ResponseEntity<Employee> getBookId(@PathVariable("id") int id) {
		Employee emp = empServices.getEmpById(id);
		if(emp==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.of(Optional.of(emp));
	}
	
	@PostMapping("/employees/add")
	public ResponseEntity<Employee> addBook(@RequestBody Employee employee) {
		Employee emp = null;
		
		
		try {
			emp = empServices.addEmp(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(emp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
		}
	}
	
	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		try {
			empServices.deleteEmpById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		}
	}
	
	@PutMapping("/employees/update/{id}")
	public ResponseEntity<Employee> updateBook(@RequestBody Employee employee,@PathVariable("id") int id) {
		try {
			empServices.updateEmpById(employee, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
