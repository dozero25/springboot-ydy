package com.study.springbootydy.repository;

import com.study.springbootydy.web.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeRepository {
    public int addEmployee(EmployeeDto employeeDto);
    public List<EmployeeDto> getEmployee();
}
