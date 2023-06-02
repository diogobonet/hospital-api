package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.entities.base.Pessoa;
import com.hospital.hospitalapi.domain.enums.MedicoEspecialidadeEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico extends Pessoa {
    private String CRM;

    @Enumerated(EnumType.STRING)
    @Column(name = "Especialidade")
    private MedicoEspecialidadeEnum Especialidade;
    private LocalDate HorarioTrabalho;

    @OneToMany
    @JoinColumn(name = "ConsultaId")
    private List<Consulta> Consultas;

    public Medico (){
    }

    public Medico(
            String nome,
            LocalDate dataNascimento,
            String sexo,
            String endereco,
            String CPF,
            String CRM,
            MedicoEspecialidadeEnum especialidade,
            LocalDate horarioTrabalho,
            List<Consulta> consultas) {
        super(
                nome,
                dataNascimento,
                sexo,
                endereco,
                CPF);
        this.CRM = CRM;
        this.Especialidade = especialidade;
        this.HorarioTrabalho = horarioTrabalho;
        this.Consultas = consultas;
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

    public LocalDate getHorarioTrabalho() {
        return HorarioTrabalho;
    }

    public void setHorarioTrabalho(LocalDate horarioTrabalho) {
        HorarioTrabalho = horarioTrabalho;
    }

    public List<Consulta> getConsultas() {
        return Consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        Consultas = consultas;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "CRM='" + CRM + '\'' +
                ", Especialidade=" + Especialidade +
                ", HorarioTrabalho=" + HorarioTrabalho +
                '}';
    }
}
