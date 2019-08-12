package com.springboot.ThymlfCRUDEmployee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@GetMapping("/addemployee")
	public String addemployee(Model model) {
		model.addAttribute("employee", new Employeeboot());
		return "add-employee";
	}

	@PostMapping("/formresponse")
	public String formresponsehere(@Valid @ModelAttribute("employee")  Employeeboot emp,BindingResult result) {
		System.out.println(emp);
		if(result.hasErrors()) {
			return "add-employee";
		}else {
		emprepo.save(emp);
		}
		return "redirect:/";
	}

	@DeleteMapping("/deleteemployee/{id}")
	public String dlete(@PathVariable Integer id) {

		emprepo.deleteById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/updateemployee/{id}")
	public String update(@PathVariable Integer id, Model model) {
		Optional<Employeeboot> findById = emprepo.findById(id);

		Employeeboot employeeboot = findById.get();

		model.addAttribute("employee", employeeboot);

		return "add-employee";

	}

}
