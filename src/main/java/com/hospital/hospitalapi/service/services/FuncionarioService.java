package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Cirurgia;
import com.hospital.hospitalapi.domain.entities.Consulta;
import com.hospital.hospitalapi.domain.entities.Exame;
import com.hospital.hospitalapi.domain.entities.Funcionario;
import com.hospital.hospitalapi.repository.repositories.CirurgiaRepository;
import com.hospital.hospitalapi.repository.repositories.ConsultaRepository;
import com.hospital.hospitalapi.repository.repositories.ExameRepository;
import com.hospital.hospitalapi.repository.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;
    private final CirurgiaRepository cirurgiaRepository;
    private final ConsultaRepository consultaRepository;
    private final ExameRepository exameRepository;

    @Autowired
    public FuncionarioService(
            FuncionarioRepository repository,
            CirurgiaRepository cirurgiaRepository,
            ConsultaRepository consultaRepository,
            ExameRepository exameRepository) {
        this.repository = repository;
        this.cirurgiaRepository = cirurgiaRepository;
        this.consultaRepository = consultaRepository;
        this.exameRepository = exameRepository;
    }

    public Object ObterFuncionarioPorCpf(String cpf) {
        Optional<Funcionario> funcionario = repository.ObterFuncionarioPorCpf(cpf);
        if (!funcionario.isPresent())
            throw new IllegalStateException("Funcionário com o CPF " + cpf + " não encontrado.");
        return funcionario;
    }

    public List<Funcionario> ListarFuncionarios(){
        return repository.findAll();
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
        else
            throw new IllegalStateException("Funcionário com o CPF " + cpf + " não existe.");
    }

    public void RemoverFuncionarioPorId(Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        if (funcionario.isPresent())
            repository.deleteById(id);
        else
            throw new IllegalStateException("Funcionário com Id " + id + " não existe.");
    }

    public Object AlterarSalarioFuncionario(String cpf, double salario) {
        Funcionario funcionario = repository.ObterFuncionarioPorCpf(cpf).orElseThrow(() -> new IllegalStateException("Funcionário com Id: " + cpf + " não existe na base de dados."));
        if (salario == funcionario.getSalario() || salario <= 0)
            funcionario.setSalario(salario);
        else {
            throw new IllegalStateException("Erro ao alterar o salário: salário precisa ser maior que o atual ou precisa ser informado algum valor.");
        }

        return funcionario;
    }

    public Object CriarCirurgia(Cirurgia cirurgia) {
        Optional<Cirurgia> consultaPorId = cirurgiaRepository.findById(cirurgia.getId());
        if (consultaPorId.isPresent())
            throw new IllegalStateException("Cirurgia com id " + consultaPorId.get().getId() + "já existe na base de dados.");

        return cirurgiaRepository.save(cirurgia);
    }

    public Object CriarConsulta(Consulta consulta) {
        Optional<Consulta> consultaPorId = consultaRepository.findById(consulta.getId());
        if (consultaPorId.isPresent())
            throw new IllegalStateException("Consulta com id " + consultaPorId.get().getId() + "já existe na base de dados.");

        return consultaRepository.save(consulta);
    }

    public Object CriarExame(Exame exame) {
        Optional<Exame> consultaPorId = exameRepository.findById(exame.getId());
        if (consultaPorId.isPresent())
            throw new IllegalStateException("Exame com id " + consultaPorId.get().getId() + "já existe na base de dados.");

        return exameRepository.save(exame);
    }
}
