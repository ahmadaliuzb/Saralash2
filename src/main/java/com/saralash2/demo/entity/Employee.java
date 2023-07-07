package com.saralash2.demo.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 06/07/2023 - 10:27 PM
 * Created by Akhmadali
 */

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(length = 14)
    private String pifl;

    @DateTimeFormat(pattern="yyyy.mm.dd")
    private Date hireDate;

    @ManyToOne
    private Organization organization;

    public Employee(Integer id, String firstName, String lastName, String pifl, Date hireDate, Organization organization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pifl = pifl;
        this.hireDate = hireDate;
        this.organization = organization;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
