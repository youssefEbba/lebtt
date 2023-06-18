package com.example.demo.GestionConge.services;



import com.example.demo.GestionConge.model.dto.EmployeeDto;
import com.example.demo.GestionConge.model.entity.Employee;
import com.example.demo.GestionConge.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeDto getEmployee(Integer id) {

        Optional<Employee> employee =this.employeeRepo.findById(id);
        if(employee.isPresent())
            return EmployeeDto.EtoDto(employee.get());
        else
            return  null;
    }

    public  void deleteEmployee(Integer id) {

        this.employeeRepo.deleteById(id);
    }

    public List<Employee> getAllEmployee() {

        return employeeRepo.findAll();
    }

}
