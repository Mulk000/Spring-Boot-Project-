package com.codeline.ccsb.Services;

import com.codeline.ccsb.DTO.ProductDto;
import com.codeline.ccsb.Entity.Product;
import com.codeline.ccsb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll().stream()
                .filter(p -> Boolean.TRUE.equals(p.getIsActive()))
                .toList();
    }

    public Product saveProduct(ProductDto dot) {
        Product product=new Product();
        product.setName(dot.getName());
        product.setCategory(dot.getCategory());
        product.setPrice(dot.getPrice());
        product.setQuantity(dot.getQuantity());
        product.setCreatedDate(new Date());
        product.setIsActive(Boolean.TRUE);
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, ProductDto dto) throws Exception {
        Product existingProduct = productRepository.findById(id).get();
        if (existingProduct != null && existingProduct.getIsActive()) {
            existingProduct.setName(dto.getName());
            existingProduct.setCategory(dto.getCategory());
            existingProduct.setPrice(dto.getPrice());
            existingProduct.setQuantity(dto.getQuantity());
            existingProduct.setUpdatedDate(new Date());
            return productRepository.save(existingProduct);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteProduct(Integer id) throws Exception {
        Product existingProduct = productRepository.findById(id).get();
        if (existingProduct != null && existingProduct.getIsActive()) {
            existingProduct.setUpdatedDate(new Date());
            existingProduct.setIsActive(Boolean.FALSE);
            productRepository.save(existingProduct);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Product getProductById(Integer id) throws Exception {
        Product existingProduct = productRepository.findById(id).get();
        if (existingProduct != null && existingProduct.getIsActive()) {
            return existingProduct;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

}