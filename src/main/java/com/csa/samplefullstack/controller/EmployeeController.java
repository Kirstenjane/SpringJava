
package com.csa.samplefullstack.controller;


import com.csa.samplefullstack.entity.Employee;
import com.csa.samplefullstack.repository.EmployeeRepository;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author mico3
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @RequestMapping("/employees")
    public List<Employee> getAllEmployees(){
   return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @GetMapping ("/employees/{id}")
    public Employee getEmployeeFromId(@PathVariable long id){
        return employeeRepository.findById((long) id).get();
    }
    @PutMapping("/employees")
    public Employee putEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
         employeeRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}

//I kennat
