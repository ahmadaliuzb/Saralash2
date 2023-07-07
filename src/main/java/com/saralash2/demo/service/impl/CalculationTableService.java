package com.saralash2.demo.service.impl;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.CalculationTableDto;
import com.saralash2.demo.dto.DtoForApi2;
import com.saralash2.demo.dto.OrganizationDto;

import java.text.ParseException;

/**
 * 06/07/2023 - 11:04 PM
 * Created by Akhmadali
 */
public interface CalculationTableService {

    ApiResponse create(CalculationTableDto calculationTableDto) throws ParseException;

    ApiResponse readAll();

    ApiResponse readById(Integer id);

    ApiResponse update(Integer id,CalculationTableDto calculationTableDto) throws ParseException;

    ApiResponse delete(Integer id);



}
