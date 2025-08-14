package com.sample.apiapp.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sample.apiapp.Config.JWTUtil;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserAccounts {
	
	@Autowired
	JWTUtil util;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> request)
	{
		String userid=request.get("userid");
		String password=request.get("password");
		try {
			if(userid.equals("admin") && password.equals("123456"))
			{
				String token=util.generateToken(userid);
				return ResponseEntity.ok(token);
			}
		}
		catch(Exception ex){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("OOPS Something Went Wrong!");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body("Invalid Login");
	}
	
	@GetMapping("/dashboard")
	public ResponseEntity<?> Dashboard(
			@RequestHeader("Authorization") String authHeader)
	{
		System.out.println(authHeader);
		try {
			if(authHeader!=null && authHeader.startsWith("Bearer "))
			{
				String token=authHeader.substring(7);
				String userid=util.validateToken(token);
				if(userid!=null)
				{
					return ResponseEntity.ok("Token is Valid. Welcome:"+userid);
				}
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body("Invalid Token");
			}
			else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body("Token is Missing!");
			}
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body("Invalid Token");
		}
	}
	
	

}
