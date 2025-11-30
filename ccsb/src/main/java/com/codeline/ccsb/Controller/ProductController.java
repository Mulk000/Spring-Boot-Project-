package com.codeline.ccsb.Controller;

import com.codeline.ccsb.DTO.ProductDto;
import com.codeline.ccsb.Entity.Product;
import com.codeline.ccsb.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("create")
    public Product CreateProduct( @Valid @RequestBody ProductDto requestObj) {
        Product product = productService.saveProduct(requestObj);
        return product;
    }
    @GetMapping("getAll")
    public List<Product> GetAllProduct() {
        List<Product> productList = productService.GetAllProducts();
        return productList;
       }

    @GetMapping("getById")
    public Product getProductById(@RequestParam int id)throws Exception {
        return productService.getProductById(id);
    }

    @PutMapping("update/{id}")
    public Product UpdateCourse(@PathVariable Integer id, @Valid @RequestBody ProductDto updatedObj ) throws Exception {
        return productService.updateProduct(id,updatedObj);


}
@DeleteMapping("Delete/{id}")
    public String DeleteCourse(@PathVariable int id) throws Exception {
        productService.deleteProduct(id);
        return "Success";

}

}

