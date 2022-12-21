package com.study.springbootydy.repository;

import com.study.springbootydy.web.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);

}
