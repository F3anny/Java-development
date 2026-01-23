package com.example.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173", "http://localhost:5174"})
public class TestController {

    @GetMapping("/login")
    public ResponseEntity<Map<String, Object>> loginInfo() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "This is a REST API. Use POST /api/auth/login to login");
        response.put("endpoints", Map.of(
            "register", "POST /api/auth/register",
            "login", "POST /api/auth/login",
            "me", "GET /api/auth/me",
            "logout", "POST /api/auth/logout"
        ));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "Spring Security API is running");
        response.put("port", 8095);
        response.put("endpoints", Map.of(
            "register", "POST /api/auth/register",
            "login", "POST /api/auth/login",
            "me", "GET /api/auth/me",
            "logout", "POST /api/auth/logout"
        ));
        return ResponseEntity.ok(response);
    }
}
