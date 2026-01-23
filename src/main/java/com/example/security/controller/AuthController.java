package com.example.security.controller;

import com.example.security.dto.AuthResponse;
import com.example.security.dto.LoginRequest;
import com.example.security.dto.UserRegistrationDto;
import com.example.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173", "http://localhost:5174"})
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto,
                                                     BindingResult result) {
        if (result.hasErrors()) {
            String errorMessage = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + ", " + msg2)
                    .orElse("Validation failed");
            return ResponseEntity.badRequest()
                    .body(new AuthResponse(false, errorMessage));
        }

        try {
            userService.registerNewUser(registrationDto);
            return ResponseEntity.ok(new AuthResponse(true, "User registered successfully"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(new AuthResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(new AuthResponse(true, "Login successful", loginRequest.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponse(false, "Invalid username or password"));
        }
    }

    @GetMapping("/me")
    public ResponseEntity<AuthResponse> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && 
            !authentication.getName().equals("anonymousUser")) {
            return ResponseEntity.ok(new AuthResponse(true, "User is authenticated", authentication.getName()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new AuthResponse(false, "User is not authenticated"));
    }

    @PostMapping("/logout")
    public ResponseEntity<AuthResponse> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok(new AuthResponse(true, "Logout successful"));
    }

    @GetMapping("/test")
    public ResponseEntity<AuthResponse> test() {
        return ResponseEntity.ok(new AuthResponse(true, "API is working! Use POST /api/auth/login to login"));
    }
}
