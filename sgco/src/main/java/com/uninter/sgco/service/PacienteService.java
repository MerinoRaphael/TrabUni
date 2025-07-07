package com.uninter.sgco.service;

import com.uninter.sgco.repository.PacienteRepository;
import com.uninter.sgco.model.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Cadastra um novo paciente
    public Paciente cadastrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Lista todos os pacientes
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }
}
