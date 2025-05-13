package org.example.ex1.Controller;

import org.example.ex1.Entity.Product;
import org.example.ex1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @GetMapping("/getProductById")
    public Product getProductById(@RequestBody Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody Long id) {
        productService.deleteProduct(id);
    }
}
