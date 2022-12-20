package com.study.springboot202210ydy.repository;

import com.study.springboot202210ydy.web.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);
    public List<CategoryDto> getCategories();
    //select 결과가 여러값일 때 list로 잡아준다.
    public int modifyCategory(CategoryDto categoryDto);
}
