package com.vcube.sbapp13.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.sbapp13.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

	Employee findByEphone(long ephone);
	  boolean existsByEphone(Long ephone);
}
