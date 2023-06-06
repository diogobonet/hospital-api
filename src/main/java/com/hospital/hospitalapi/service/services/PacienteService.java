package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Paciente;
import com.hospital.hospitalapi.repository.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // define que esta classe será uma fornecedora de serviço da aplicação(onde criamos a lógica de negócio)
public class PacienteService {
    private final PacienteRepository repository; // faz a injeção de dependência do repositório realacionado ao paciente

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Object ObterPacientePorId(Long id){
        boolean existe = repository.existsById(id); // faz comunicação com o repositório para retornar um booleano se esciste esse Id dentro do banco de dados
        if (!existe)
            throw new IllegalStateException("Paciente com o Id " + id + " não existe");
        return repository.findById(id); // pede para o repositório buscar um paciente na base de dados com o Id informado
    }

    public List<Paciente> ListarPacientes(){
        return repository.findAll();
    }

    public Object ObterPacientePorCpf(String cpf){
        Optional<Paciente> paciente = repository.ObterPacientePorCpf(cpf); // faz comunicação com o repositório para retornar um paciente pelo CPF dentro da base de dados
        if (!paciente.isPresent())
            throw new IllegalStateException("Paciente com o CPF " + cpf + " não encontrado.");
        return paciente;
    }

    public Object CriarPaciente(Paciente paciente) {
            Optional<Paciente> pacienteEncontrado = repository.findById(paciente.getId()); // faz comunicação com o repositório para reportar um paciente pelo Id dentro da base de dados
            if (pacienteEncontrado.isPresent()){
                throw new IllegalStateException("Paciente já existe na base de dados.");
            }
            return repository.save(paciente); // pede para o repositório salvar esse ojeto na base de dados
    }

    public void RemoverPaciente(Long id) {
        boolean existe = repository.existsById(id); // comunica com o repositório dopaciente para fazer a verificação se existe um paciente na base de dados com o Id informado
        if (!existe){
            throw new IllegalStateException("Paciente com o Id" + id + " não existe.");
        }
        repository.deleteById(id); // pede para o repositório remover um ojeto da base de dados com o Id informado
    }
}
