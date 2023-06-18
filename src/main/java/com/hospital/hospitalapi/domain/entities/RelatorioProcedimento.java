package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.entities.base.Procedimento;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "RelatorioProcedimento")
public class RelatorioProcedimento extends Procedimento {
    public RelatorioProcedimento(
            LocalDate dataAgendada,
            String nome,
            Paciente paciente,
            Funcionario funcionario) {
        super(
                dataAgendada,
                nome,
                paciente,
                funcionario);
    }
}
