package com.example.productlist.Service;

import com.example.productlist.Entity.Category;
import com.example.productlist.Entity.Product;
import com.example.productlist.Mapper.ProductMapper;
import com.example.productlist.Repository.CategoryRepository;
import com.example.productlist.Repository.ProductRepository;
import com.example.productlist.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){
    Category category=    categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category Not Found"));
     //dto ->entity
      Product product=  ProductMapper.toProductEntity(productDTO,category);
        product = productRepository.save(product);
        //entity to dto
        ProductDTO productDTO1=ProductMapper.toProductDTO(product);
        return productDTO1;
    }
    //get all products
    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }
    public ProductDTO getProductById(Long id){
       Product product= productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }
    //update product

    public ProductDTO updateProduct( Long id , ProductDTO productDTO ){
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
       Category category= categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        productRepository.save(product);
        return  ProductMapper.toProductDTO(product);
    }
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return  "Product"+id+ "has been deleted";
    }
}
