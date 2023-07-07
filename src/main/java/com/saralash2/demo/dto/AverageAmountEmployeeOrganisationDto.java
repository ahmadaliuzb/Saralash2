package com.saralash2.demo.dto;

import com.saralash2.demo.entity.Employee;
import com.saralash2.demo.entity.Organization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 07/07/2023 - 3:23 PM
 * Created by Akhmadali
 */
public class AverageAmountEmployeeOrganisationDto {

    private Double averageAmount;

    public Map<Employee,Organization> employeeOrganizationMap=new HashMap<>();

    public Double getAverageAmount() {
        return averageAmount;
    }

    public void setAverageAmount(Double averageAmount) {
        this.averageAmount = averageAmount;
    }
}
