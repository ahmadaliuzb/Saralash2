package com.saralash2.demo.dto;

import com.saralash2.demo.entity.Organization;
import com.saralash2.demo.entity.Region;
import jakarta.persistence.ManyToOne;

/**
 * 06/07/2023 - 11:21 PM
 * Created by Akhmadali
 */
public class OrganizationDto {

    private String name;


    private Integer regionId;


    private Integer organizationId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
