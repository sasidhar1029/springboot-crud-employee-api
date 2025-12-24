package com.vcube.sbapp13.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee4")
@Setter
@Getter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int eid;
	String ename;
	double esal;
	long ephone;
	int age;
	String city;

}
