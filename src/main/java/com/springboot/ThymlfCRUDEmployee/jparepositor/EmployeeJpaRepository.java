package com.springboot.ThymlfCRUDEmployee.jparepositor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ThymlfCRUDEmployee.entity.Employeeboot;

public interface EmployeeJpaRepository extends JpaRepository<Employeeboot, Integer> {

	
}
