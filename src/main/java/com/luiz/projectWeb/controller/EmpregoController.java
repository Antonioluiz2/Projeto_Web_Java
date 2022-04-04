package com.luiz.projectWeb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luiz.projectWeb.model.Emprego;
import com.luiz.projectWeb.repository.EmpregoRepository;

@Controller
public class EmpregoController {

	@Autowired
	EmpregoRepository empregoRepository;
	@RequestMapping("/empregos")
	public String listadeEmpregos(Model model) {
		model.addAttribute("empregos", empregoRepository.findAll());
		return "lista";
	}
	@GetMapping("/add")
	public String empregoForm(Model model) {
		model.addAttribute("emprego", new Emprego());
		return "empregoForm";
	}
	@PostMapping("/process")
	public String processForm(@Valid Emprego emprego, BindingResult result) {
		if(result.hasErrors()) {
			return "empregoForm";
			}
		empregoRepository.save(emprego);
		return "redirect:/empregos";
	}
}
