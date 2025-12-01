package nextplay.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import nextplay.backend.models.User;
import nextplay.backend.repositories.UserRepository;

@Component
public class UserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDataLoader(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

@Override
public void run(String... args) {

    userRepository.findByEmail("admin@nextplay.cl")
        .orElseGet(() -> {
            User admin = new User();
            admin.setEmail("admin@nextplay.cl");
            admin.setPassword(passwordEncoder.encode("1234"));
            admin.setRole("ADMIN");

            
            admin.setAddress("Admin Street 123");
            admin.setCity("Santiago");
            admin.setGender("Otros");      
            admin.setTerms(true);         

            return userRepository.save(admin);
        });
}
}