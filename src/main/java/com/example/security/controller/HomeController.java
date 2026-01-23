package com.example.security.controller;

import com.example.security.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173", "http://localhost:5174"})
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<AuthResponse> home(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok(new AuthResponse(true, "Welcome!", authentication.getName()));
        }
        return ResponseEntity.ok(new AuthResponse(false, "Not authenticated"));
    }
}
