package com.sample.apiapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import com.sample.apiapp.Services.authService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	@Autowired
	private authService serv;
	
	@GetMapping("/login")
	public String loginform(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String userid,
			@RequestParam String password,
			Model model,
			HttpSession session)
	{
		try
		{
			String token=serv.login(userid, password);
			if(token!=null)
			{
			session.setAttribute("jwt", token);
			return "redirect:/dashboard";
			}
			else {
				model.addAttribute("error","Invalid Credentials");
				return "login";
			}
		}
		catch(Exception ex)
		{
			model.addAttribute("error","Invalid Credentials");
			return "login";
		}
	}
	
	@GetMapping("/dashboard")
	public String Dashboard(Model model,HttpSession session)
	{
		String token=(String)session.getAttribute("jwt");
		if(token==null)
		{
			return "redirect:/login";
		}
		try {
			String userid=serv.dashboard(token);
			model.addAttribute("userid", userid);
			return "dashboard";
		}
		catch(HttpClientErrorException ex)
		{
			if(ex.getStatusCode()==HttpStatus.UNAUTHORIZED)
			{
				session.invalidate();
				
			}
			return "redirect:/login?expired";
		}
	}
}
