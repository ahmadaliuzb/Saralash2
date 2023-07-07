package com.saralash2.demo.controller;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.RegionDto;
import com.saralash2.demo.service.impl.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 07/07/2023 - 12:40 AM
 * Created by Akhmadali
 */

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> readById(@PathVariable Integer id) {
        ApiResponse apiResponse = regionService.readById(id);
        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> readAll() {
        return new ResponseEntity<>(regionService.readAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody RegionDto regionDto) {
        ApiResponse apiResponse = regionService.create(regionDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody RegionDto regionDto, @PathVariable Integer id) {
        ApiResponse apiResponse = regionService.update(id, regionDto);

        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = regionService.delete(id);

        if (!apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
