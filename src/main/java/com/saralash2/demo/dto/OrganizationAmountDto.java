package com.saralash2.demo.dto;

import com.saralash2.demo.entity.Organization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 07/07/2023 - 11:34 AM
 * Created by Akhmadali
 */
public class OrganizationAmountDto {

    public List<Organization> organizations = new ArrayList<>();

    private Integer organizationsNumber= organizations.size();

    private Double totalAmount = Double.valueOf(0);

    public List<Organization> getOrganizations() {
        return organizations;
    }


    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
