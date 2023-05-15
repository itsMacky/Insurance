package com.velocity.repository;

import org.springframework.data.repository.CrudRepository;

import com.velocity.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	public Employee getById(Integer id);

}
