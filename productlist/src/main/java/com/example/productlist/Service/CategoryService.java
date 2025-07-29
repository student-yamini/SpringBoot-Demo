package com.example.productlist.Service;

import com.example.productlist.Controller.ProductController;
import com.example.productlist.Entity.Category;
import com.example.productlist.Mapper.CategoryMapper;
import com.example.productlist.Repository.CategoryRepository;
import com.example.productlist.dto.CategoryDTO;
import com.example.productlist.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CategoryDTO> getAllCategories(){
       return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }
    public CategoryDTO getCategoryById(Long id){
        Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("CategoryId is not found"));
       return CategoryMapper.toCategoryDTO(category);
    }
    public String DeleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category"+id+"has been deleted";
    }
}
