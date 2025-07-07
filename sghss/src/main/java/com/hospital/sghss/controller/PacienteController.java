package com.hospital.sghss.controller;

import java.util.List;
import com.hospital.sghss.model.Paciente;
import com.hospital.sghss.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

  @Autowired
  private PacienteService service;

  @PostMapping
  public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente dto) {
    Paciente salvo = service.cadastrar(dto);
    return ResponseEntity.ok(salvo);
  }

  @GetMapping
  public ResponseEntity<List<Paciente>> listar() {
    return ResponseEntity.ok(service.listarTodos());
  }
}
