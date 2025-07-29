package com.example.productlist.Service;

import com.example.productlist.Entity.Category;
import com.example.productlist.Mapper.CategoryMapper;
import com.example.productlist.Repository.CategoryRepository;
import com.example.productlist.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
     private CategoryRepository categoryRepository;
    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
      return   CategoryMapper.toCategoryDTO(category);

    }
}
