package com.uninter.sgco.controller;

import com.uninter.sgco.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final JwtService jwtService;

    public LoginController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String senha) {
        // Validação simples (você pode adicionar lógica real de autenticação)
        if ("raphel.merino@hotmail".equals(email) && "12345".equals(senha)) {
            String token = jwtService.generateToken(email);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
        }
    }
}
