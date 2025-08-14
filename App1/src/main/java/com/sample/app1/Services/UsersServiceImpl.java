package com.sample.app1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.app1.Models.User;
import com.sample.app1.Repos.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersRepo repo;

	@Override
	public User save(User user) {
		return repo.save(user);
	}

	@Override
	public Optional<User> getById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public void Delete(int id) {
		repo.deleteById(id);

	}

}
