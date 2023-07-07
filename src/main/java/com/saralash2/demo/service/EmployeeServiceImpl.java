package com.saralash2.demo.service;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.EmployeeDto;
import com.saralash2.demo.dto.EmployeeDto;
import com.saralash2.demo.entity.Employee;
import com.saralash2.demo.entity.Organization;
import com.saralash2.demo.entity.Region;
import com.saralash2.demo.repository.EmployeeRepository;
import com.saralash2.demo.repository.OrganizationRepository;
import com.saralash2.demo.repository.RegionRepository;
import com.saralash2.demo.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * 06/07/2023 - 11:02 PM
 * Created by Akhmadali
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    OrganizationRepository organizationRepository;


    @Override
    public ApiResponse create(EmployeeDto employeeDto) throws ParseException {
        Employee employee=new Employee();
        Optional<Organization> organization = null;
        if(employeeDto.getOrganizationId()!=null){
            organization=organizationRepository.findById(employeeDto.getOrganizationId());
        }
        if(organization!=null){
            employee.setOrganization(organization.get());
        }


        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPifl(employeeDto.getPifl());

        String sDate1=employeeDto.getHireDate();
        Date date=new SimpleDateFormat("yyyy.MM.dd").parse(sDate1);
        employee.setHireDate(date);



        employeeRepository.save(employee);

        return new ApiResponse("Successfully created",true);
    }

    @Override
    public ApiResponse readAll() {

        return new ApiResponse(employeeRepository.findAll(),true);
    }

    @Override
    public ApiResponse readById(Integer id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        return optionalEmployee.map(employee -> new ApiResponse(employee,true)).orElseGet(() -> new ApiResponse("Employee not found",false));
    }

    @Override
    public ApiResponse update(Integer id, EmployeeDto employeeDto) throws ParseException {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if(!optionalEmployee.isPresent()){
            return new ApiResponse("Employee not found",false);
        }

        Employee employee=optionalEmployee.get();

        Optional<Organization> organization = null;
        if(employeeDto.getOrganizationId()!=null){
            organization=organizationRepository.findById(employeeDto.getOrganizationId());
        }
        if(organization!=null){
            employee.setOrganization(organization.get());
        }

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPifl(employeeDto.getPifl());

        String sDate1=employeeDto.getHireDate();
        Date date=new SimpleDateFormat("yyyy.MM.dd").parse(sDate1);
        employee.setHireDate(date);

        employeeRepository.save(employee);

        return new ApiResponse("Successfully updated",true);

    }

    @Override
    public ApiResponse delete(Integer id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if(!optionalEmployee.isPresent()){
            return new ApiResponse("Employee not found",false);
        }

        employeeRepository.deleteById(id);

        return new ApiResponse("Successfully deleted",true);
    }
}
