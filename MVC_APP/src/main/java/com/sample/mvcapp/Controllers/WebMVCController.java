package com.sample.mvcapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.mvcapp.Models.Product;
import com.sample.mvcapp.Services.ProductsService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class WebMVCController {
	
	@Autowired
	ProductsService serv;

	@GetMapping
	public String ProductList(Model model)
	{
		model.addAttribute("products", serv.GetAllProducts());
		return "list";
	}
	
	@GetMapping("/add")
	public String AddProduct(Model model)
	{
		model.addAttribute("product", new Product());
		return "form";
	}
	
	@PostMapping
	public String Save(@ModelAttribute("product") @Valid Product prod,
			BindingResult result)
	{
		if(result.hasErrors())
		{
			return "form";
		}
		serv.Save(prod);
		return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public String EditProduct(@PathVariable int id,Model model)
	{
		model.addAttribute("product", serv.GetByProductId(id));
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteProduct(@PathVariable int id)
	{
		serv.DeleteByProductId(id);
		return "redirect:/products";
	}
}
