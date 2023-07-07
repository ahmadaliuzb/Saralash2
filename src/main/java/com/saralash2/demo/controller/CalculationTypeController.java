package com.saralash2.demo.controller;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.CalculationTableDto;
import com.saralash2.demo.service.impl.CalculationTableService;
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
@RequestMapping("/api/v1/calculationType")
public class CalculationTypeController {

    private final CalculationTableService calculationTableService;

    @Autowired
    public CalculationTypeController(CalculationTableService calculationTableService) {
        this.calculationTableService = calculationTableService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> readById(@PathVariable Integer id) {
        ApiResponse apiResponse = calculationTableService.readById(id);
        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> readAll() {
        return new ResponseEntity<>(calculationTableService.readAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody CalculationTableDto calculationTableDto) throws ParseException {
        ApiResponse apiResponse = calculationTableService.create(calculationTableDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody CalculationTableDto calculationTableDto, @PathVariable Integer id) throws ParseException {
        ApiResponse apiResponse = calculationTableService.update(id, calculationTableDto);

        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = calculationTableService.delete(id);

        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
