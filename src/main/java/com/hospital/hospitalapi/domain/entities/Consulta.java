package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.entities.base.Procedimento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Consulta")
public class Consulta extends Procedimento {
    @ManyToOne
    @JoinColumn(name = "MedicoId")
    private Medico MedicoResponsavel;
    private String Laudo;

    public Consulta(
            int codigo,
            LocalDate dataAgendada,
            Paciente paciente,
            Funcionario funcionario,
            Medico medicoResponsavel,
            String laudo) {
        super(
                codigo,
                dataAgendada,
                paciente,
                funcionario);
        this.MedicoResponsavel = medicoResponsavel;
        this.Laudo = laudo;
    }

    public Medico getMedicoResponsavel() {
        return MedicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        MedicoResponsavel = medicoResponsavel;
    }

    public String getLaudo() {
        return Laudo;
    }

    public void setLaudo(String laudo) {
        Laudo = laudo;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "MedicoResponsavel=" + MedicoResponsavel +
                ", Laudo='" + Laudo + '\'' +
                '}';
    }
}
