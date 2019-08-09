package com.springboot.ThymlfCRUDEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.ThymlfCRUDEmployee.entity.Employeeboot;
import com.springboot.ThymlfCRUDEmployee.jparepositor.EmployeeJpaRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeJpaRepository emprepo;

	@GetMapping("/")
	public String getall(Model model) {

		

		model.addAttribute("thelist", emprepo.findAll());

		return "employee-list";
	}
}
