package com.study.springbootydy.web.controller;

import com.study.springbootydy.service.EmployeeService;
import com.study.springbootydy.web.dto.CMRespDto;
import com.study.springbootydy.web.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/api/employee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity
                .created(null)
                .body(new CMRespDto<>("직원등록완료", employeeService.addEmployee(employeeDto)));
    }
    @GetMapping("/api/employees")
    public ResponseEntity<?> getEmployee(){
        return ResponseEntity.ok(employeeService.getEmployee());
    }
}
