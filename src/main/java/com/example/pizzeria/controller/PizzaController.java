package com.example.pizzeria.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/")
public class PizzaController {
	
	
	@GetMapping()
	public String home(@RequestParam(name="keyword", required = false) String keyword, Model model) {
		
		List<Pizza> listPizza;
		
		if (keyword!=null && !keyword.isEmpty()) {
			
			 listPizza = pizzarepository.findByNameLike("%" + keyword + "%");
			
		} else {
			
			 listPizza = pizzarepository.findAll();
		}
		model.addAttribute("pizze", listPizza);
		return "index";
	}
	
	 @Autowired
	 PizzaRepository pizzarepository;
	 
	 
	 @GetMapping("/pizza/{id}")
	 public String detail (@PathVariable("id") Integer id , Model model ) {
		 
		 Optional<Pizza> k = pizzarepository.findById(id);
		 
		 if (k.isPresent()) {
			 model.addAttribute("pizza", k.get());
		 } else {
			 return "404";
		 }
		 
		 return "/detail";
	 }
	 
	 /*
	 @GetMapping("/search")
		public String home(@RequestParam(name="keyword", required = false) String keyword, Model model) {
			
			List<Pizza> listPizza = pizzarepository.findByNameLike("%" + keyword + "%");
			model.addAttribute("pizze", listPizza);
			return "index";
		} */

}
