package com.sample.app1.Services;

import java.util.List;
import java.util.Optional;

import com.sample.app1.Models.User;

public interface UsersService {

	User save(User user);
	Optional<User> getById(int id);
	List<User> getAllUsers();
	void Delete(int id);
}
