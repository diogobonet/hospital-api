package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Paciente;
import com.hospital.hospitalapi.repository.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Object ObterPacientePorId(Long id){
        boolean existe = repository.existsById(id);
        if (!existe)
            throw new IllegalStateException("Paciente com o Id " + id + " não existe");
        return repository.findById(id);
    }

    public List<Paciente> ListarPacientes(){
        return repository.findAll();
    }

    public Object findPacienteByCpf(String cpf){
        Optional<Paciente> paciente = repository.findPacienteByCpf(cpf);
        if (!paciente.isPresent())
            throw new IllegalStateException("Paciente com o CPF " + cpf + " não encontrado.");
        return paciente;
    }

    public Object CriarPaciente(Paciente paciente) {
            Optional<Paciente> pacienteEncontrado = repository.findById(paciente.getId());
            if (pacienteEncontrado.isPresent()){
                throw new IllegalStateException("Paciente já existe na base de dados.");
            }
            return repository.save(paciente);
    }

    public void RemoverPaciente(Long id) {
        boolean existe = repository.existsById(id);
        if (!existe){
            throw new IllegalStateException("Paciente com o Id" + id + " não existe.");
        }
        repository.deleteById(id);
    }
}
