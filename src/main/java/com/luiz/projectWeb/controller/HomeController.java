package com.luiz.projectWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
  public String homeApp(Model model){
		model.addAttribute("mensagem", "Esta messagem foi injetada atravez do model");
		
	  return "index";
  }

}
