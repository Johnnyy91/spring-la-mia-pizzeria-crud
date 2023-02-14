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
	/*
	 * 1. creare da dbeaver almeno 1 pizza  ok
	 * 2. scrivere il codice thymeleaf in index.html per visualizzare le pizze  ok
	 *   - come primo step visualizzo semplicemente <p th:text="$pizze"></p> ---> [org.zzasdasd.Pizza237823723]  ok 
	 *   - come secondo step, le visualizzo per bene facendo th:each
	 *   
	 */
	
	@GetMapping()
	public String home(Model model) {
		
		//somma(1,3)
		//int c = somma (1,3)
		//System.out.print(c);
		
		List<Pizza> listPizza = pizzarepository.findAll();
		
		model.addAttribute("name" , "Claudio");
		model.addAttribute("pizze", listPizza);
		return "index";
	}
	
	 @Autowired
	 PizzaRepository pizzarepository;

}
