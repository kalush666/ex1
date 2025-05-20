package org.example.ex1.Controller;

import org.example.ex1.Entity.Product;
import org.example.ex1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getProductById")
    public ResponseEntity<Product> getProductById(@RequestBody Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(@RequestBody Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.NO_CONTENT);
    }
}