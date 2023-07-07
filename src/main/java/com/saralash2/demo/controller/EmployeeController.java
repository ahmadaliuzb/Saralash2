package com.saralash2.demo.controller;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.EmployeeDto;
import com.saralash2.demo.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * 07/07/2023 - 1:55 AM
 * Created by Akhmadali
 */

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> readById(@PathVariable Integer id) {
        ApiResponse apiResponse = employeeService.readById(id);
        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> readAll() {
        return new ResponseEntity<>(employeeService.readAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody EmployeeDto employeeDto) throws ParseException {
        ApiResponse apiResponse = employeeService.create(employeeDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody EmployeeDto employeeDto, @PathVariable Integer id) throws ParseException {
        ApiResponse apiResponse = employeeService.update(id, employeeDto);

        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = employeeService.delete(id);

        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
