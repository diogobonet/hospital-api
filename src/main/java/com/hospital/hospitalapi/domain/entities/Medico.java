package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.entities.base.Pessoa;
import com.hospital.hospitalapi.domain.enums.MedicoEspecialidadeEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico extends Pessoa {
    public String CRM;

    @Enumerated(EnumType.STRING)
    @Column(name = "Especialidade")
    public MedicoEspecialidadeEnum Especialidade;

    public Medico (){
    }

    public Medico(
            String nome,
            LocalDate dataNascimento,
            String sexo,
            String endereco,
            String CPF,
            String CRM,
            MedicoEspecialidadeEnum especialidade) {
        super(
                nome,
                dataNascimento,
                sexo,
                endereco,
                CPF);
        this.CRM = CRM;
        this.Especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public MedicoEspecialidadeEnum getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(MedicoEspecialidadeEnum especialidade) {
        Especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "CRM='" + CRM + '\'' +
                ", Especialidade=" + Especialidade +
                '}';
    }
}
