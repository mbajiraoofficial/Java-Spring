package com.sample.apiapp.Config;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Configuration
public class JWTUtil {
	
	private static final String SECRET="abcdefghabcdefghabcdefghabcdefgh";
	private static final SecretKey KEY= Keys.hmacShaKeyFor
			(SECRET.getBytes(StandardCharsets.UTF_8));
	
	public String generateToken(String userid)
	{
		return Jwts.builder()
		.subject(userid)
		.issuedAt(new Date())
		.expiration(new Date(System.currentTimeMillis()+3600000))
		.signWith(KEY)
		.compact();
	}
	
	public String validateToken(String token)
	{
		Claims claims=Jwts.parser()
		.verifyWith(KEY)
		.build()
		.parseSignedClaims(token)
		.getPayload();
		return claims.getSubject();
	}

}
