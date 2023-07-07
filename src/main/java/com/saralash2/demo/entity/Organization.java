package com.saralash2.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * 06/07/2023 - 10:10 PM
 * Created by Akhmadali
 */

@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @ManyToOne
    private Region region;


    @ManyToOne
    private Organization organization;


    public Organization(Integer id, String name, Region region, Organization organization) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.organization = organization;
    }

    public Organization() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
