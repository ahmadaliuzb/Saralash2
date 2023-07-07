package com.saralash2.demo.controller;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.OrganizationDto;
import com.saralash2.demo.dto.RegionDto;
import com.saralash2.demo.service.impl.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 07/07/2023 - 1:55 AM
 * Created by Akhmadali
 */

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> readById(@PathVariable Integer id) {
        ApiResponse apiResponse = organizationService.readById(id);
        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> readAll() {
        return new ResponseEntity<>(organizationService.readAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody OrganizationDto organizationDto) {
        ApiResponse apiResponse = organizationService.create(organizationDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody OrganizationDto organizationDto, @PathVariable Integer id) {
        ApiResponse apiResponse = organizationService.update(id, organizationDto);

        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = organizationService.delete(id);

        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
