package com.hospital.hospitalapi.repository.repositories;

import com.hospital.hospitalapi.domain.entities.Paciente;
import com.hospital.hospitalapi.domain.entities.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    @Query(value = "FROM Paciente p WHERE p.CPF = :cpf") // aqui criamos uma Query customizada para buscar um paciente na tabela com o cpf informado no parametro
    // essa sintaxe se refere não ao SQL normal mas ao JPQL que é um SQL orientado a ojetos
    Optional<Paciente> ObterPacientePorCpf(String cpf); // criamos o método de busca de um paciente pelo CPF que vai realizar no banco de dados a query descrica logo acima
}
