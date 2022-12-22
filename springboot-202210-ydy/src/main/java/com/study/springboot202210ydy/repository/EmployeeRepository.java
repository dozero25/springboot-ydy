package com.study.springboot202210ydy.repository;

import com.study.springboot202210ydy.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmpDto empDto);
}
