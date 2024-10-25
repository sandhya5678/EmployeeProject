package com.example.Employee1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Employee1.Dao.EmployeeDao;
import com.example.Employee1.Entity.Employee;

@RestController
@RequestMapping("/emp6")
@CrossOrigin(origins = "*", allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class EmployeeController {
	@Autowired
	EmployeeDao empDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public Employee saveEmp (@RequestBody Employee employee) {
		return empDao.saveEmp(employee);
	}
	
	@GetMapping
	public List<Employee> fetchAll(){
		return empDao.fetchAll();
	}
	
	@GetMapping("/emp2")
	public String callEmployee2() {
		 String employee2ApiUrl = "http://localhost:8081/emp/employee";
		 String responce = restTemplate.getForObject(employee2ApiUrl,String.class);
		return responce;
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmp(@PathVariable int id) {
		empDao.deleteEmp(id);
	}
}
