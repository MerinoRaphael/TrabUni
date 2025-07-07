package com.uninter.sgco.controller;

import com.uninter.sgco.model.Paciente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    // Simulação de banco de dados com ID auto-increment
    private static final AtomicInteger counter = new AtomicInteger(1);

    @PostMapping
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
        paciente.setId((long) counter.getAndIncrement()); // Incrementa o ID
        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }
}
