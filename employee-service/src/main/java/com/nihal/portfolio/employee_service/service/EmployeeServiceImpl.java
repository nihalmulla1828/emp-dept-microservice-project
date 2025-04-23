package com.nihal.portfolio.employee_service.service;

import com.nihal.portfolio.employee_service.dto.APIResponseDto;
import com.nihal.portfolio.employee_service.dto.DepartmentDto;
import com.nihal.portfolio.employee_service.dto.EmployeeDto;
import com.nihal.portfolio.employee_service.entity.Employee;
import com.nihal.portfolio.employee_service.mapper.EmployeeMapper;
import com.nihal.portfolio.employee_service.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private RestTemplate restTemplate;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.mapEmpDtoToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapEmpEntityToDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeByEmail(String email, String departmentCode) {
        Employee employee = employeeRepository.findByEmail(email);
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+departmentCode, DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
        EmployeeDto employeeDto = employeeMapper.mapEmpEntityToDto(employee);
        employeeDto.setDepartmentCode(departmentCode);
        return new APIResponseDto(employeeDto,departmentDto);
    }
}
