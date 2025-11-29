package nextplay.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nextplay.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
