package nextplay.backend.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nextplay.backend.models.User;
import nextplay.backend.repositories.UserRepository;

public class UserService {
    
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
        if (repository.existsByEmail(user.getEmail())){
            throw new RuntimeException("El correo ya está en uso");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User login(String email, String password) {
        User user = repository.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }
        return user;
    }
 }
