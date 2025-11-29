package nextplay.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nextplay.backend.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
