package com.vcube.sbapp13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.sbapp13.model.Employee;
import com.vcube.sbapp13.service.EmployeeService;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;

	   @PostMapping("/insertEmp")
	    public ResponseEntity<?> insertEmployee(@RequestBody Employee emp) {
	        try {
	            return ResponseEntity.ok(employeeservice.saveEmployee(emp));
	        } catch (RuntimeException e) {
	            return ResponseEntity
	                    .badRequest()
	                    .body(e.getMessage());
	        }
	    }

	@GetMapping("getEmpList")
	List<Employee> getEmpList() {
		return employeeservice.getEmpList();
	}

	@GetMapping("getEmployeeInfo/{eid}")
	Employee getEmployeeInfo(@PathVariable("eid") int eid) {
		return employeeservice.getEmployeeById(eid);
	}

	@GetMapping("getEmpByPhone/{ephone}")
	Employee getEmployeeByEphone(@PathVariable("ephone") Employee ephone) {
		return employeeservice.saveEmployee(ephone);
	}

	@PostMapping("updateEmp/{eid}")
	Employee updateEmployee(@RequestBody Employee employee, @PathVariable("eid") int eid) {
		Employee existed = employeeservice.getEmployeeById(eid);
		existed.setAge(employee.getAge());
		existed.setCity(employee.getCity());
		existed.setEname(employee.getEname());
		existed.setEphone(employee.getEphone());
		existed.setEsal(employee.getEsal());
		return employeeservice.updateEmployee(existed);

	}
	
	@DeleteMapping("delete/{eid}")
	 String deleteEmployee(@PathVariable ("eid") int eid) {
		 return employeeservice.deleteEmpyById(eid);
	 }
}
