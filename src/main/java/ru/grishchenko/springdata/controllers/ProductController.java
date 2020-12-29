package ru.grishchenko.springdata.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.grishchenko.springdata.models.Product;
import ru.grishchenko.springdata.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false, name = "mincost") Integer minCost,
                                        @RequestParam(required = false, name = "maxcost") Integer maxCost) {
        if ((minCost != null) && maxCost != null) {
            return productService.getProductBetween(minCost, maxCost);
        } else if (minCost != null) {
            return productService.getProductGreaterThan(minCost);
        } else if (maxCost != null){
            return productService.getProductLessThan(maxCost);
        }
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addNewProduct(newProduct);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        productService.deleteProductById(id);
        response.sendRedirect(request.getContextPath()  + "/products");
    }

}
