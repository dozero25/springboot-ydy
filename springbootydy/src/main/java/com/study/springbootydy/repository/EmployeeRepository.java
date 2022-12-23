package com.study.springbootydy.repository;

import com.study.springbootydy.web.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    public int addEmployee(EmployeeDto employeeDto);
}
