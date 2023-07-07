package com.saralash2.demo.dto;

import com.saralash2.demo.entity.Organization;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 06/07/2023 - 11:26 PM
 * Created by Akhmadali
 */
public class EmployeeDto {

    private String firstName;

    private String lastName;

    private String pifl;


    private String hireDate;


    private Integer organizationId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPifl() {
        return pifl;
    }

    public void setPifl(String pifl) {
        this.pifl = pifl;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
