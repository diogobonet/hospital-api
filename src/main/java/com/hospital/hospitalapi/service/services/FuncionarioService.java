package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Funcionario;
import com.hospital.hospitalapi.repository.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;

    @Autowired
    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Object ObterFuncionarioPorCpf(String cpf) {
        Optional<Funcionario> funcionario = repository.ObterFuncionarioPorCpf(cpf);
        if (!funcionario.isPresent())
            throw new IllegalStateException("Funcionário com o CPF " + cpf + " não encontrado.");
        return funcionario;
    }

    public Object CriarFuncionario(Funcionario funcionario) {
        Optional<Funcionario> funcPorCpf = repository.ObterFuncionarioPorCpf(funcionario.getCPF());
        if (funcPorCpf.isPresent())
            throw new IllegalStateException("Funcionário com id " + funcPorCpf.get().getId() + "já existe na base de dados.");

        if (funcionario.getDataNascimento().equals(LocalDate.now()))
            throw new IllegalStateException("Data de nascimento precisa ser maior que a data atual.");

        return repository.save(funcionario);
    }

    public void RemoverFuncionarioPorCpf(String cpf) {
        Optional<Funcionario> funcionario = repository.ObterFuncionarioPorCpf(cpf);
        if (funcionario.isPresent())
            repository.deleteById(funcionario.get().getId());
        else {
            throw new IllegalStateException("Funcionário com o CPF " + cpf + " não existe.");
        }
    }
}
