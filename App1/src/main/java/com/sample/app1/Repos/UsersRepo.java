package com.sample.app1.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.app1.Models.User;


@Repository
public interface UsersRepo extends JpaRepository<User, Integer> {

}
