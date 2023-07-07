package com.saralash2.demo.service.impl;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.EmployeeDto;
import com.saralash2.demo.dto.OrganizationDto;

import java.text.ParseException;

/**
 * 06/07/2023 - 11:04 PM
 * Created by Akhmadali
 */
public interface EmployeeService {

    ApiResponse create(EmployeeDto employeeDto) throws ParseException;

    ApiResponse readAll();

    ApiResponse readById(Integer id);

    ApiResponse update(Integer id,EmployeeDto employeeDto) throws ParseException;

    ApiResponse delete(Integer id);
}
