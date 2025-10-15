package com.example.CRUD_application.controller;

import com.example.CRUD_application.model.Employee; 
import com.example.CRUD_application.service.EmployeeService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
 
import java.util.List; 
 
 
@RestController 
@RequestMapping("/api/employees") 
@CrossOrigin(origins = "*") 
public class EmployeeController { 
 
    @Autowired 
    private EmployeeService employeeService; 
 
    @PostMapping 
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){ 
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED); 
    } 
    //GetAll Rest Api 
    @GetMapping 
    public List<Employee> getAllEmployee(){ 
        return employeeService.getAllEmployee(); 
    } 
 
    //Get by Id Rest Api 
    @GetMapping("{id}") 
    // localhost:8080/api/employees/1 
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeID){ 
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeID),HttpStatus.OK); 
    } 
 
    //Update Rest Api 
@PutMapping("{id}") 
public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, 
@RequestBody Employee employee){ 
return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK); 
} 
//Delete Rest Api 
@DeleteMapping("{id}") 
public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){ 
//delete employee from db 
employeeService.deleteEmployee(id); 
return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK); 
} 
}