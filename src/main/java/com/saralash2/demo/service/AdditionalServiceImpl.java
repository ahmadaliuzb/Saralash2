package com.saralash2.demo.service;

import com.saralash2.demo.dto.*;
import com.saralash2.demo.entity.CalculationTable;
import com.saralash2.demo.entity.Employee;
import com.saralash2.demo.entity.Organization;
import com.saralash2.demo.enums.CalculationType;
import com.saralash2.demo.repository.CalculationTableRepository;
import com.saralash2.demo.repository.EmployeeRepository;
import com.saralash2.demo.repository.OrganizationRepository;
import com.saralash2.demo.repository.RegionRepository;
import com.saralash2.demo.service.impl.AdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 07/07/2023 - 10:39 AM
 * Created by Akhmadali
 */

@Service
public class AdditionalServiceImpl implements AdditionalService {

    @Autowired
    CalculationTableRepository calculationTableRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RegionRepository regionRepository;


    @Override
    public ApiResponse methodForApi2(DtoForApi2 dtoForApi2) {

        List<CalculationTable> all = calculationTableRepository.findAll();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String strDate;

        Map<String, Integer> resultMap = new HashMap<>();

        for (CalculationTable calculationTable : all) {
            if (calculationTable.getRate() > dtoForApi2.getRate()) {
                strDate = formatter.format(calculationTable.getDate());
                if (dtoForApi2.getMonth().equals(strDate.substring(0, 7))) {
                    Employee employee = calculationTable.getEmployee();

                    if (resultMap.containsKey(employee.getPifl())) {
                        Integer oldRate = resultMap.get(employee.getPifl());
                        resultMap.put(employee.getPifl(), oldRate + calculationTable.getRate());
                    } else {
                        resultMap.put(employee.getPifl(), calculationTable.getRate());
                    }

                }
            }
        }


        return new ApiResponse(resultMap, true);
    }

    @Override
    public ApiResponse methodForApi3(DtoForApi3 dtoForApi3) {

        List<CalculationTable> all = calculationTableRepository.findAll();


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String strDate;


        Map<String, OrganizationAmountDto> resultMap = new HashMap<>();

        for (CalculationTable calculationTable : all) {
            strDate = formatter.format(calculationTable.getDate());
            if (calculationTable.getCalculationType() == CalculationType.SALARY) {
                if (dtoForApi3.getMonth().equals(strDate.substring(0, 7))) {

                    Employee employee = calculationTable.getEmployee();
                    if (resultMap.containsKey(employee.getPifl())) {
                        OrganizationAmountDto organizationAmountDto = resultMap.get(employee.getPifl());

                        List<Organization> organizations = organizationAmountDto.getOrganizations();

                        Organization organization = calculationTable.getOrganization();

                        if (!organizations.contains(organization)) {
                            organizationAmountDto.organizations.add(organization);
                            organizationAmountDto.setTotalAmount(organizationAmountDto.getTotalAmount() + calculationTable.getAmount());
                        } else {
                            organizationAmountDto.setTotalAmount(organizationAmountDto.getTotalAmount() + calculationTable.getAmount());
                        }

                        resultMap.put(employee.getPifl(), organizationAmountDto);

                    } else {
                        OrganizationAmountDto organizationAmountDto = new OrganizationAmountDto();
                        organizationAmountDto.setTotalAmount(calculationTable.getAmount());
                        organizationAmountDto.organizations.add(calculationTable.getOrganization());
                        resultMap.put(employee.getPifl(), organizationAmountDto);

                    }
                }
            }
        }

        return new ApiResponse(resultMap, true);

    }

    @Override
    public ApiResponse methodForApi4(DtoForApi4 dtoForApi4) {
        List<CalculationTable> all = calculationTableRepository.findAll();


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String strDate;


        AverageAmountEmployeeOrganisationDto result = new AverageAmountEmployeeOrganisationDto();

        Double sumAmount = Double.valueOf(0);
        Double counter = Double.valueOf(0);

        for (CalculationTable calculationTable : all) {
            strDate = formatter.format(calculationTable.getDate());
            if (dtoForApi4.getMonth().equals(strDate.substring(0, 7))) {

                Organization organization = calculationTable.getOrganization();

                if (organization.getOrganization() != null && dtoForApi4.getOrganizationId() != null) {
                    if (organization.getOrganization().getId() == dtoForApi4.getOrganizationId()) {
                        sumAmount += calculationTable.getAmount();
                        counter++;
                        result.employeeOrganizationMap.put(calculationTable.getEmployee(), organization);
                    }
                }

            }
        }

        result.setAverageAmount(sumAmount / counter);
        return new ApiResponse(result, true);
    }


    @Override
    public ApiResponse methodForApi5(DtoForApi5 dtoForApi5) {

        List<CalculationTable> all = calculationTableRepository.findAll();


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String strDate;


        List<SalaryVacationDto> resultList = new ArrayList<>();

        for (CalculationTable calculationTable : all) {
            strDate = formatter.format(calculationTable.getDate());
            if (dtoForApi5.getMonth().equals(strDate.substring(0, 7))) {

                SalaryVacationDto salaryVacationDto = new SalaryVacationDto();
                if (calculationTable.getCalculationType() == CalculationType.SALARY) {
                    salaryVacationDto.setSalaryAmount(calculationTable.getAmount());
                }
                if (calculationTable.getCalculationType() == CalculationType.VACATION) {
                    salaryVacationDto.setVacationAmount(calculationTable.getAmount());
                }

                salaryVacationDto.setEmployee(calculationTable.getEmployee());

                resultList.add(salaryVacationDto);


            }
        }

        return new ApiResponse(resultList, true);

    }


}
