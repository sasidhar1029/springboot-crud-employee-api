package com.vcube.sbapp13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.sbapp13.model.Employee;
import com.vcube.sbapp13.repo.EmployeeRepo;

@Service
public class EmployeeService {
	// For buliding business logics we will use service
	@Autowired
	EmployeeRepo emprepo;

	// insertEmpDetails
	public Employee insertEmloyee(Employee employee) {
		return emprepo.save(employee);
	}

	// getEmpList
	public List<Employee> getEmpList() {
		return emprepo.findAll();
	}

	// getEmpById
	public Employee getEmployeeById(int eid) {
		return emprepo.findById(eid).orElseThrow(() -> new RuntimeException("Eid is not found"));
	}

	// getEmpByPhone

    public Employee saveEmployee(Employee emp) {

        if (emprepo.existsByEphone(emp.getEphone())) {
            throw new RuntimeException("❌ Phone number already exists");
        }

        return emprepo.save(emp);
    }

	// updateEmployeeById
	public Employee updateEmployee(Employee employee) {
		return emprepo.save(employee);
	}

	// DeleteEmployeeById
	public String deleteEmpyById(int eid) {
		emprepo.deleteById(eid);
		return "Deleted " + eid + " Employee Successfully";
	}
}
