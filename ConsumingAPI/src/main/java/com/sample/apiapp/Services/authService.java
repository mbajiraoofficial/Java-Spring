package com.sample.apiapp.Services;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class authService {
	
	@Value("${api.auth.url}")
	private String baseURL;
	
	private final RestTemplate rest=new RestTemplate();
	
	public String login(String userid,String password)
	{
		String loginurl=baseURL+"/login";
//		System.out.println(loginurl);
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String, String> body=Map.of("userid",userid,"password",password);
		HttpEntity<Map<String,String>> entity=
				new HttpEntity<Map<String,String>>(body,headers);
		ResponseEntity<String> response= rest.exchange(
				loginurl,
				HttpMethod.POST,
				entity,
				String.class);
		return response.getBody();
	}
	public String dashboard(String token)
	{
		String dashboardURL=baseURL+"/dashboard";
		HttpHeaders headers=new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity<Void> entity=new HttpEntity<>(headers);
		ResponseEntity<String> response=
				rest.exchange(
						dashboardURL,
						HttpMethod.GET,
						entity,
						String.class
						);
		return response.getBody();
	}
}
