package com.sample.apiapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.apiapp.Models.Product;
import com.sample.apiapp.Services.apiService;

@Controller
@RequestMapping("/products")
public class TestController {

	@Autowired
	private apiService serv;
	
	@GetMapping
	public String list(Model model)
	{
		model.addAttribute("products",serv.getAll());
		return "list";
	}
	
	@GetMapping("/add")
	public String AddProduct(Model model)
	{
		model.addAttribute("product",new Product());
		return "productform";
	}
	
	@PostMapping
	public String Add(@ModelAttribute Product prod)
	{
		serv.add(prod);
		return "redirect:/products";
	}
	@GetMapping("/edit/{id}")
	public String EditForm(@PathVariable int id,Model mode)
	{
		mode.addAttribute("product",serv.getById(id));
		return "productform";
	}
	@PostMapping("/update/{id}")
	public String Update(@PathVariable int id,@ModelAttribute Product prod)
	{
		serv.update(id, prod);
		return "redirect:/products";
	}
	@GetMapping("/delete/{id}")
	public String Delete(@PathVariable int id)
	{
		serv.delete(id);
		return "redirect:/products";
	}
}
