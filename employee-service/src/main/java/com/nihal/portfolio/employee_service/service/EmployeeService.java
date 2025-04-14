package com.nihal.portfolio.employee_service.service;

import com.nihal.portfolio.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeByEmail(String email);
}
