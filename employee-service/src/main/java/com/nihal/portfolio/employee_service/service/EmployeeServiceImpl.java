package com.nihal.portfolio.employee_service.service;

import com.nihal.portfolio.employee_service.dto.EmployeeDto;
import com.nihal.portfolio.employee_service.entity.Employee;
import com.nihal.portfolio.employee_service.mapper.EmployeeMapper;
import com.nihal.portfolio.employee_service.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.mapEmpDtoToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapEmpEntityToDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return employeeMapper.mapEmpEntityToDto(employee);
    }
}
