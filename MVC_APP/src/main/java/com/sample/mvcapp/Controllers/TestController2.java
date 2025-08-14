package com.sample.mvcapp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/V2")
public class TestController2 {

	@GetMapping("/greet")
	public String greetUser()
	{
		return "Hello user this is from Version-2";
	}
}
