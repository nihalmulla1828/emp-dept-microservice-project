package com.nihal.portfolio.employee_service.controller;

import com.nihal.portfolio.employee_service.dto.EmployeeDto;
import com.nihal.portfolio.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{email}")
    public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable("email") String email){
        EmployeeDto employeeDto = employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
}
