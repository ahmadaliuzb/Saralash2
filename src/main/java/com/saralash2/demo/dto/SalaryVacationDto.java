package com.saralash2.demo.dto;

import com.saralash2.demo.entity.Employee;

import java.util.List;

/**
 * 07/07/2023 - 3:43 PM
 * Created by Akhmadali
 */
public class SalaryVacationDto {

    private Employee employee;
    private Double salaryAmount;
    private Double vacationAmount;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Double getVacationAmount() {
        return vacationAmount;
    }

    public void setVacationAmount(Double vacationAmount) {
        this.vacationAmount = vacationAmount;
    }
}
