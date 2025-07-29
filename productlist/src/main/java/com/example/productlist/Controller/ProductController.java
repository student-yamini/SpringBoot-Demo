package com.example.productlist.Controller;

import com.example.productlist.Service.ProductService;
import com.example.productlist.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
     @Autowired
     ProductService productService;
     @GetMapping
     public List<ProductDTO> getAllProducts(){
         return productService.getAllProducts();
     }
     @GetMapping("/{id}")
     public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
     }
     //create product
     @PostMapping
     public ResponseEntity <ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO createProduct=productService.createProduct(productDTO);
          return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
     }
    //get all products
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
         return productService.updateProduct(id,productDTO);
    }
    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable Long id){
         return productService.deleteProduct(id);
    }
}
