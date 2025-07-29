package com.example.productlist.Controller;

import com.example.productlist.Service.CategoryService;
import com.example.productlist.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
     private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO>  createCategory(@RequestBody CategoryDTO categoryDTO){
return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //get all categories
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
      return  categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){

        return categoryService.getCategoryById(id);
    }
    @DeleteMapping("/{id}")
    public  String DeleteCategory(@PathVariable Long id){
       return categoryService.DeleteCategory(id);
    }

}
