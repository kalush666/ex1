package org.example.ex1.Service;

import org.example.ex1.Entity.Product;
import org.example.ex1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public void createProduct(Product product) {
        repository.save(product);
    }
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void updateProduct(Long id,Product productDetails) {
        Product product = repository.findById(id).orElse(null);
        if (product != null) {
            product.setProductName(productDetails.getProductName());
            product.setPrice(productDetails.getPrice());
            product.setDescription(productDetails.getDescription());
            repository.save(product);
        }
    }
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}

