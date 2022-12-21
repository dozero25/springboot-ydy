package com.study.springbootydy.web.controller;

import com.study.springbootydy.service.OptionService;
import com.study.springbootydy.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity
                .created(URI.create("/api/option/category"+optionService.addCategory(categoryDto)))
                .body(categoryDto);
    }

}
