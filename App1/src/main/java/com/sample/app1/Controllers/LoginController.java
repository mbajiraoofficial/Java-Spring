package com.sample.app1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String Login()
	{
		return "userlogin";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String userid,
			@RequestParam String password,
			HttpSession session,
			Model model)
	{
		if(userid.equals("admin") && password.equals("123456"))
		{
			session.setAttribute("LoggedInnUser", userid);
			return "redirect:/dashboard";
		}
		else
		{
			model.addAttribute("error","Invalid Userid/Password");
			return "userlogin";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/login";
	}
}
