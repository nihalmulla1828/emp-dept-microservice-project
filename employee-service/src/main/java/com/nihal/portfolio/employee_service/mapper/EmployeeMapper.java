package com.nihal.portfolio.employee_service.mapper;

import com.nihal.portfolio.employee_service.dto.EmployeeDto;
import com.nihal.portfolio.employee_service.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee mapEmpDtoToEntity(EmployeeDto employeeDto){
        return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail(), employeeDto.getDepartmentCode());
    }

    public EmployeeDto mapEmpEntityToDto(Employee employee){
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());
    }
}
