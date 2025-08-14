package com.sample.app1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String showDashboard(HttpSession session)
	{
//		if(session.getAttribute("LoggedInnUser")==null)
//		{
//			return "redirect:/login";
//		}
		return "index";
	}

}
