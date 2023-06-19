package com.hospital.hospitalapi.repository.repositories;

import com.hospital.hospitalapi.domain.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    @Query("FROM Funcionario f WHERE f.CPF = :cpf")
    Optional<Funcionario> ObterFuncionarioPorCpf(String cpf);
}

