package com.hospital.sghss.service;

import com.hospital.sghss.model.Usuario;
import com.hospital.sghss.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public String login(String email, String senha) {
        Usuario u = usuarioRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuário não existe"));
        if (!u.getSenha().equals(senha)) {
            throw new RuntimeException("Credenciais inválidas");
        }
        return gerarToken(18);
    }

    private String gerarToken(int length) {
        byte[] bytes = new byte[length];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding()
                     .encodeToString(bytes).substring(0, length);
    }
}
