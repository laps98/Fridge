package dev.java10x.Fridge.controller;

import dev.java10x.Fridge.infra.security.TokenService;
import dev.java10x.Fridge.model.User;
import dev.java10x.Fridge.repository.UserRepository;
import dev.java10x.Fridge.viewModel.LoginRequest;
import dev.java10x.Fridge.viewModel.RegisterRequest;
import dev.java10x.Fridge.viewModel.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/auth"))
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthController(UserRepository repository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest body) {
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.passworld(), user.getPassworld())) {

            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new UserResponse(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest body) {
        Optional<User> user = this.repository.findByEmail(body.email());

        if (user.isEmpty()) {

            User newUser = new User();
            newUser.setPassworld(passwordEncoder.encode(body.passworld()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new UserResponse(newUser.getName(), token));
        }

        return ResponseEntity.badRequest().build();
    }
}
