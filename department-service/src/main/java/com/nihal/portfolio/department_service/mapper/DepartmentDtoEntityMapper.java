package com.nihal.portfolio.department_service.mapper;

import com.nihal.portfolio.department_service.dto.DepartmentDto;
import com.nihal.portfolio.department_service.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoEntityMapper {

    public DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(department.getId(), department.getDepartmentName(), department.getDepartmentDescription(), department.getDepartmentCode());
    }

    public Department mapToDepartmentEntity(DepartmentDto departmentDto){
        return new Department(departmentDto.getId(), departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());
    }
}
