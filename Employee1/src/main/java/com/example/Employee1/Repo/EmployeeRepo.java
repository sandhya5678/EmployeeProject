package com.example.Employee1.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employee1.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
