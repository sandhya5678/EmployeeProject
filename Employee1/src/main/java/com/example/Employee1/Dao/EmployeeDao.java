package com.example.Employee1.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Employee1.Entity.Employee;
import com.example.Employee1.Repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo empRepo;

	public Employee saveEmp(Employee employee) {
		return empRepo.save(employee);
	}

	public List<Employee> fetchAll() {
		return empRepo.findAll();
	}

	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}

	
}
