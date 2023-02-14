package com.example.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/")
public class PizzaController {
	
	
	@GetMapping()
	public String home(Model model) {
		
	
		
		List<Pizza> listPizza = pizzarepository.findAll();
		
		model.addAttribute("name" , "Claudio");
		model.addAttribute("pizze", listPizza);
		return "index";
	}
	
	 @Autowired
	 PizzaRepository pizzarepository;

}
