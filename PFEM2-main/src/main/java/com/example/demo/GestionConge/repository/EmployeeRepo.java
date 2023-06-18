package com.example.demo.GestionConge.repository;



import com.example.demo.GestionConge.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
    
    Optional<Employee> findByEmail(String email);
}
