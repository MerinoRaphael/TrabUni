package com.hospital.sghss.controller;

import com.hospital.sghss.dto.LoginRequest;
import com.hospital.sghss.dto.LoginResponse;
import com.hospital.sghss.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) {
        String token = authService.login(req.getEmail(), req.getSenha());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
