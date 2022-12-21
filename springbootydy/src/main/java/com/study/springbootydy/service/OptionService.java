package com.study.springbootydy.service;

import com.study.springbootydy.repository.OptionRepository;
import com.study.springbootydy.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public int addCategory(CategoryDto categoryDto){
        return optionRepository.saveCategory(categoryDto) > 0 ? categoryDto.getCategoryId() : 0;

    }
}
