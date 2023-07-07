package com.saralash2.demo.entity;

import com.saralash2.demo.enums.CalculationType;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 06/07/2023 - 10:04 PM
 * Created by Akhmadali
 */

@Entity
public class CalculationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Employee employee;

    private Double amount;

    private Integer rate;

    @DateTimeFormat(pattern="yyyy.mm.dd")
    private Date date;

    @ManyToOne
    private Organization organization;

    private CalculationType calculationType;

    public CalculationTable(Integer id, Employee employee, Double amount, Integer rate, Date date, Organization organization, CalculationType calculationType) {
        this.id = id;
        this.employee = employee;
        this.amount = amount;
        this.rate = rate;
        this.date = date;
        this.organization = organization;
        this.calculationType = calculationType;
    }

    public CalculationTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(CalculationType calculationType) {
        this.calculationType = calculationType;
    }
}
