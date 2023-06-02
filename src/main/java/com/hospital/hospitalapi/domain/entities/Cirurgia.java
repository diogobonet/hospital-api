package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.entities.base.Procedimento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Cirurgia")
public class Cirurgia extends Procedimento {
    @ManyToOne
    @JoinColumn(name = "MedicoId")
    private Medico MedicoResponsavel;
    private List<String> Observacoes;

    public Cirurgia (){
    }

    public Cirurgia(
            int codigo,
            LocalDate dataAgendada,
            Paciente paciente,
            Funcionario funcionario,
            Medico medicoResponsavel,
            List<String> observacoes) {
        super(
                codigo,
                dataAgendada,
                paciente,
                funcionario);
        MedicoResponsavel = medicoResponsavel;
        Observacoes = observacoes;
    }

    public Medico getMedicoResponsavel() {
        return MedicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        MedicoResponsavel = medicoResponsavel;
    }

    public List<String> getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(List<String> observacoes) {
        Observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Cirurgia{" +
                "MedicoResponsavel=" + MedicoResponsavel +
                ", Observacoes=" + Observacoes +
                '}';
    }
}
