package com.saralash2.demo.service;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.CalculationTableDto;
import com.saralash2.demo.dto.CalculationTableDto;
import com.saralash2.demo.dto.DtoForApi2;
import com.saralash2.demo.entity.CalculationTable;
import com.saralash2.demo.entity.Employee;
import com.saralash2.demo.entity.Organization;
import com.saralash2.demo.enums.CalculationType;
import com.saralash2.demo.repository.CalculationTableRepository;
import com.saralash2.demo.repository.EmployeeRepository;
import com.saralash2.demo.repository.OrganizationRepository;
import com.saralash2.demo.service.impl.CalculationTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 06/07/2023 - 11:02 PM
 * Created by Akhmadali
 */

@Service
public class CalculationTableServiceImpl implements CalculationTableService {

    @Autowired
    CalculationTableRepository calculationTableRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public ApiResponse create(CalculationTableDto calculationTableDto) throws ParseException {

        Optional<Organization> organization = organizationRepository.findById(calculationTableDto.getOrganizationId());
        Optional<Employee> employee = employeeRepository.findById(calculationTableDto.getEmployeeId());

        CalculationTable calculationTable = new CalculationTable();
        calculationTable.setAmount(calculationTableDto.getAmount());

        String sDate1=calculationTableDto.getDate();
        Date date=new SimpleDateFormat("yyyy.MM.dd").parse(sDate1);
        calculationTable.setDate(date);

        calculationTable.setRate(calculationTableDto.getRate());
        calculationTable.setEmployee(employee.get());
        calculationTable.setOrganization(organization.get());

        switch (calculationTableDto.getCalculationType()) {
            case "SALARY":
                calculationTable.setCalculationType(CalculationType.SALARY);
                break;
            case "PENSION":
                calculationTable.setCalculationType(CalculationType.PENSION);
                break;
            case "AWARD":
                calculationTable.setCalculationType(CalculationType.AWARD);
                break;
            case "VACATION":
                calculationTable.setCalculationType(CalculationType.VACATION);
                break;
        }


        calculationTableRepository.save(calculationTable);

        return new ApiResponse("Successfully created", true);
    }

    @Override
    public ApiResponse readAll() {

        return new ApiResponse(calculationTableRepository.findAll(), true);
    }

    @Override
    public ApiResponse readById(Integer id) {

        Optional<CalculationTable> optionalCalculationTable = calculationTableRepository.findById(id);

        return optionalCalculationTable.map(calculationTable -> new ApiResponse(calculationTable, true)).orElseGet(() -> new ApiResponse("CalculationTable not found", false));
    }

    @Override
    public ApiResponse update(Integer id, CalculationTableDto calculationTableDto) throws ParseException {

        Optional<CalculationTable> optionalCalculationTable = calculationTableRepository.findById(id);

        if (!optionalCalculationTable.isPresent()) {
            return new ApiResponse("CalculationTable not found", false);
        }

        CalculationTable calculationTable = optionalCalculationTable.get();

        Optional<Organization> organization = organizationRepository.findById(calculationTableDto.getOrganizationId());
        Optional<Employee> employee = employeeRepository.findById(calculationTableDto.getEmployeeId());

        calculationTable.setAmount(calculationTableDto.getAmount());

        String sDate1=calculationTableDto.getDate();
        Date date=new SimpleDateFormat("yyyy.MM.dd").parse(sDate1);
        calculationTable.setDate(date);

        calculationTable.setRate(calculationTableDto.getRate());
        calculationTable.setOrganization(organization.get());
        calculationTable.setEmployee(employee.get());

        switch (calculationTableDto.getCalculationType()) {
            case "SALARY":
                calculationTable.setCalculationType(CalculationType.SALARY);
                break;
            case "PENSION":
                calculationTable.setCalculationType(CalculationType.PENSION);
                break;
            case "AWARD":
                calculationTable.setCalculationType(CalculationType.AWARD);
                break;
            case "VACATION":
                calculationTable.setCalculationType(CalculationType.VACATION);
                break;
        }

        calculationTableRepository.save(calculationTable);

        return new ApiResponse("Successfully updated", true);

    }

    @Override
    public ApiResponse delete(Integer id) {

        Optional<CalculationTable> optionalCalculationTable = calculationTableRepository.findById(id);

        if (!optionalCalculationTable.isPresent()) {
            return new ApiResponse("CalculationTable not found", false);
        }

        calculationTableRepository.deleteById(id);

        return new ApiResponse("Successfully deleted", true);
    }




}
