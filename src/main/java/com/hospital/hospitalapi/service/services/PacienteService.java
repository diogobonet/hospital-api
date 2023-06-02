package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Paciente;
import com.hospital.hospitalapi.repository.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> ListarPacientes(){
        return repository.findAll();
    }

    public Paciente CriarPaciente(Paciente paciente) {
        System.out.println(paciente);
        return paciente;
    }
}
