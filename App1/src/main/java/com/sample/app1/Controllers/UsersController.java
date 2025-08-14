package com.sample.app1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.app1.Services.UsersService;


@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService serv;
	
	@GetMapping
	public String GetAllUsers(Model model)
	{
		model.addAttribute("users", serv.getAllUsers());
		return "dashboard";
	}
}
