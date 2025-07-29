package com.example.productlist.Mapper;

import com.example.productlist.Entity.Category;
import com.example.productlist.dto.CategoryDTO;

import javax.swing.text.html.parser.Entity;

public class CategoryMapper {
    //entity to dto
    public static CategoryDTO toCategoryDTO(Category category){
        if(category==null){
            return  null;
        }
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        //Converts a list of Product entities to a list of ProductDTOs using a ProductMapper.
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
      return categoryDTO;
    }

      //DTO to entity
      public static Category toCategoryEntity(CategoryDTO categoryDTO){
          Category category=new Category();
          category.setName(categoryDTO.getName());
          return category;
      }
}
