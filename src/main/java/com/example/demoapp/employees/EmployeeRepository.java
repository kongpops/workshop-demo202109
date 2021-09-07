package com.example.demoapp.employees;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

//    List<Employee> findAllByIdAndName(int id, String name);
}
