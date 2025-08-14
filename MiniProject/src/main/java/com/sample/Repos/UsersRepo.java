package com.sample.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.Models.User;
import java.util.List;


@Repository 
public interface UsersRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);
	User findByUsernameAndPassword(String username,String password);
	List<User> findByRoleAndActiveFalse(String role);
}
