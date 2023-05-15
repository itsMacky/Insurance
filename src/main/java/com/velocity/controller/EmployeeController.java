package com.velocity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.velocity.model.Employee;
import com.velocity.repository.EmployeeRepository;
import com.velocity.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id, @RequestBody Employee employee) {

		Employee emp = employeeService.getEmployeeById(id);

		emp.setPolicyId(employee.getPolicyId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setDOB(employee.getDOB());
		emp.setEmailAddress(employee.getEmailAddress());
		emp.setPhoneNumber(employee.getPhoneNumber());

		Employee emp1 = employeeRepository.save(emp);

		return ResponseEntity.ok().body(emp1);
	
}
}
