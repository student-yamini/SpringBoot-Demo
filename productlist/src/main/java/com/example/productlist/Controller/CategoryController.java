package com.example.productlist.Controller;

import com.example.productlist.Entity.Category;
import com.example.productlist.Service.CategoryService;
import com.example.productlist.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
     private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO>  createCategory(@RequestBody CategoryDTO categoryDTO){
return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
}
