package com.saralash2.demo.repository;

import com.saralash2.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 06/07/2023 - 11:34 PM
 * Created by Akhmadali
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByOrganizationId(Integer organizationId);
}
