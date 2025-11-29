package nextplay.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nextplay.backend.models.Product;
import nextplay.backend.services.ProductService;

@CrossOrigin(origins = "*") // Para permitir llamadas desde React
@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/id")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/id")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }



}
