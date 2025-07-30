package com.example.productlist.Mapper;

import com.example.productlist.Entity.Category;
import com.example.productlist.Entity.Product;
import com.example.productlist.dto.ProductDTO;

public class ProductMapper {

    //entity to dto
    public static ProductDTO  toProductDTO(Product product){

      return  new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(),product.getCategory().getId());
    }
    //dto to entity
    public static Product  toProductEntity(ProductDTO productDTO, Category category){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        return  product;
    }
}
