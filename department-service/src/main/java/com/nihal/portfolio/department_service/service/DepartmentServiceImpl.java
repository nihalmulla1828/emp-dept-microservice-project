package com.nihal.portfolio.department_service.service;

import com.nihal.portfolio.department_service.dto.DepartmentDto;
import com.nihal.portfolio.department_service.entity.Department;
import com.nihal.portfolio.department_service.mapper.DepartmentDtoEntityMapper;
import com.nihal.portfolio.department_service.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;
    private DepartmentDtoEntityMapper departmentDtoEntityMapper;

    //Constructor based dependency injection
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentDtoEntityMapper departmentDtoEntityMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentDtoEntityMapper = departmentDtoEntityMapper;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = departmentDtoEntityMapper.mapToDepartmentEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return departmentDtoEntityMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return departmentDtoEntityMapper.mapToDepartmentDto(department);
    }
}
