package com.sample.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.Models.Employee;

@Repository
public interface EmployeesRepo extends JpaRepository<Employee, Integer> {

}
