package com.sample.Config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sample.Models.Role;
import com.sample.Models.User;
import com.sample.Repos.RolesRepo;
import com.sample.Repos.UsersRepo;

@Component
public class DataInitializer implements CommandLineRunner {
	
	@Autowired
	private RolesRepo rRepo;
	
	@Autowired
	private UsersRepo uRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void run(String... args) throws Exception {
		Role adminrole= rRepo.findByName("ROLE_ADMIN")
		.orElseGet(()->rRepo.save(new Role(0,"ROLE_ADMIN")));
		
		Role userrole= rRepo.findByName("ROLE_USER")
				.orElseGet(()->rRepo.save(new Role(0,"ROLE_USER")));
		
		if(uRepo.findByUsername("admin").isEmpty())
		{
			User admin=new User();
			admin.setUsername("admin");
			admin.setPassword(encoder.encode("admin123"));
			admin.setRoles(Set.of(adminrole));
			uRepo.save(admin);
		}
		if(uRepo.findByUsername("user").isEmpty())
		{
			User user=new User();
			user.setUsername("user");
			user.setPassword(encoder.encode("user123"));
			user.setRoles(Set.of(userrole));
			uRepo.save(user);
		}
		
		
	}

}
