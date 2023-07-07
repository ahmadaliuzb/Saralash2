package com.saralash2.demo.service;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.OrganizationDto;
import com.saralash2.demo.entity.Organization;
import com.saralash2.demo.entity.Region;
import com.saralash2.demo.repository.OrganizationRepository;
import com.saralash2.demo.repository.RegionRepository;
import com.saralash2.demo.service.impl.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 06/07/2023 - 11:02 PM
 * Created by Akhmadali
 */

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    RegionRepository regionRepository;


    @Override
    public ApiResponse create(OrganizationDto organizationDto) {

        Optional<Organization> parentOrganization = null;
        if (organizationDto.getOrganizationId() != null) {
            parentOrganization = organizationRepository.findById(organizationDto.getOrganizationId());
        }

        Organization organization = new Organization();
        if (parentOrganization != null) {
            organization.setOrganization(parentOrganization.get());
        }

        Optional<Region> region = null;
        if (organizationDto.getRegionId() != null) {
            region = regionRepository.findById(organizationDto.getRegionId());
        }

        if (region != null) {
            organization.setRegion(region.get());
        }
        organization.setName(organizationDto.getName());


        organizationRepository.save(organization);

        return new ApiResponse("Successfully created", true);
    }

    @Override
    public ApiResponse readAll() {

        return new ApiResponse(organizationRepository.findAll(), true);
    }

    @Override
    public ApiResponse readById(Integer id) {

        Optional<Organization> optionalOrganization = organizationRepository.findById(id);

        return optionalOrganization.map(organization -> new ApiResponse(organization, true)).orElseGet(() -> new ApiResponse("Organization not found", false));
    }

    @Override
    public ApiResponse update(Integer id, OrganizationDto organizationDto) {

        Optional<Organization> optionalOrganization = organizationRepository.findById(id);

        if (!optionalOrganization.isPresent()) {
            return new ApiResponse("Organization not found", false);
        }

        Organization organization = optionalOrganization.get();

        Optional<Organization> parentOrganization = null;
        if (organizationDto.getOrganizationId() != null) {
            parentOrganization = organizationRepository.findById(organizationDto.getOrganizationId());
        }

        if (parentOrganization != null) {
            organization.setOrganization(parentOrganization.get());
        }

        Optional<Region> region = null;
        if (organizationDto.getRegionId() != null) {
            region = regionRepository.findById(organizationDto.getRegionId());
        }

        if (region != null) {
            organization.setRegion(region.get());
        }

        organization.setName(organizationDto.getName());

        organizationRepository.save(organization);

        return new ApiResponse("Successfully updated", true);

    }

    @Override
    public ApiResponse delete(Integer id) {

        Optional<Organization> optionalOrganization = organizationRepository.findById(id);

        if (!optionalOrganization.isPresent()) {
            return new ApiResponse("Organization not found", false);
        }

        organizationRepository.deleteById(id);

        return new ApiResponse("Successfully deleted", true);
    }
}
