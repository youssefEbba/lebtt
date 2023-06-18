package com.example.demo.GestionConge.controller;

import com.example.demo.GestionConge.model.dto.EmployeeDto;
import com.example.demo.GestionConge.model.entity.Employee;
import com.example.demo.GestionConge.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="employees")

public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getEmployee")
    public EmployeeDto getEmployee(@RequestParam Integer id) {

        return employeeService.getEmployee(id);
    }
//    @PostMapping(value={"/postdirection"})
//    public DirectionDto SavePoste( @RequestBody DirectionDto dirct) {
//        return directionService.addPoste(dirct);
//    }

//    @PostMapping(value={"/updatedirection"})
//    public DirectionDto updatePoste( @RequestBody DirectionDto dirct) {
//
//        return directionService.updatePoste(dirct);
//    }

    @GetMapping(value={"/deleteEmployee"})
    public void deleteEmployee(Integer id) {

        employeeService.deleteEmployee(id);
    }

    @GetMapping(value={"/getallEmployee"})
    public List<Employee> getAllEmployee( ) {
        return employeeService.getAllEmployee();
    }

}
