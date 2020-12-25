package ru.grishchenko.springdata.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.grishchenko.springdata.models.Product;
import ru.grishchenko.springdata.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductBetween(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public List<Product> getProductGreaterThan(Integer min) {
        return productRepository.findAllByCostIsGreaterThanEqual(min);
    }

    public List<Product> getProductLessThan(Integer max) {
        return productRepository.findAllByCostLessThanEqual(max);
    }
}
