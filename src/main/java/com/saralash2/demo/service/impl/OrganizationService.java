package com.saralash2.demo.service.impl;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.OrganizationDto;
import com.saralash2.demo.dto.RegionDto;

/**
 * 06/07/2023 - 11:05 PM
 * Created by Akhmadali
 */
public interface OrganizationService {

    ApiResponse create(OrganizationDto organizationDto);

    ApiResponse readAll();

    ApiResponse readById(Integer id);

    ApiResponse update(Integer id,OrganizationDto organizationDto);

    ApiResponse delete(Integer id);
}
