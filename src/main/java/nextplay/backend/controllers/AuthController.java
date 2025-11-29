package nextplay.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nextplay.backend.models.User;
import nextplay.backend.services.UserService;

@CrossOrigin(origins = "*") // Para permitir llamadas desde React
@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register (@RequestBody User user) {
        return userService.register(user);
    }
    

    @PostMapping("/login")
    public User login (@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}
