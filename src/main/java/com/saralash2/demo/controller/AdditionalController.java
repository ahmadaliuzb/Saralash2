package com.saralash2.demo.controller;

import com.saralash2.demo.dto.*;
import com.saralash2.demo.service.impl.AdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 07/07/2023 - 2:48 AM
 * Created by Akhmadali
 */

@RestController
@RequestMapping("/api/v1/additional")
public class AdditionalController {

    private final AdditionalService additionalService;

    @Autowired
    public AdditionalController(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }

    @GetMapping("/api2")
    public ResponseEntity<ApiResponse> api2(@RequestBody DtoForApi2 dtoForApi2) {

        ApiResponse apiResponse = additionalService.methodForApi2(dtoForApi2);

        if(apiResponse.getMessage()==null){
            return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);

    }

    @GetMapping("/api3")
    public ResponseEntity<ApiResponse> api3(@RequestBody DtoForApi3 dtoForApi3){
        ApiResponse apiResponse = additionalService.methodForApi3(dtoForApi3);

        if(apiResponse.getMessage()==null){
            return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @GetMapping("/api4")
    public ResponseEntity<ApiResponse> api4(@RequestBody DtoForApi4 dtoForApi4){
        ApiResponse apiResponse = additionalService.methodForApi4(dtoForApi4);

        if(apiResponse.getMessage()==null){
            return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @GetMapping("/api5")
    public ResponseEntity<ApiResponse> api5(@RequestBody DtoForApi5 dtoForApi5){
        ApiResponse apiResponse = additionalService.methodForApi5(dtoForApi5);

        if(apiResponse.getMessage()==null){
            return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
