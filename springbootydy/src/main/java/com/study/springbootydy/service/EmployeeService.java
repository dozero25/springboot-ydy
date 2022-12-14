package com.study.springbootydy.service;

import com.study.springbootydy.repository.EmployeeRepository;
import com.study.springbootydy.web.dto.CategoryDto;
import com.study.springbootydy.web.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public int addEmployee(EmployeeDto employeeDto){
        return employeeRepository.addEmployee(employeeDto) > 0 ? employeeDto.getEmpId() : 0;
    }

    public List<EmployeeDto> getEmployee() {
        return employeeRepository.getEmployee();
    }
}
