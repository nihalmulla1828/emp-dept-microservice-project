package com.nihal.portfolio.employee_service.repository;

import com.nihal.portfolio.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public Employee findByEmail(String email);
}
