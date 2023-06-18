package com.hospital.hospitalapi.domain.entities.base;

import com.hospital.hospitalapi.domain.entities.Funcionario;
import com.hospital.hospitalapi.domain.entities.Paciente;
import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nome;
    private LocalDate DataAgendada;
    private String Paciente;

    @OneToOne
    @JoinColumn(name = "FuncionarioId")
    private Funcionario Funcionario;

    public Procedimento() {
    }

    public Procedimento(
            LocalDate dataAgendada,
            String nome,
            String paciente,
            Funcionario funcionario) {
        this.DataAgendada = dataAgendada;
        this.Nome = nome;
        this.Paciente = paciente;
        this.Funcionario = funcionario;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }


    public LocalDate getDataAgendada() {
        return DataAgendada;
    }

    public String getPaciente() {
        return Paciente;
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }


    public void setDataAgendada(LocalDate dataAgendada) {
        DataAgendada = dataAgendada;
    }

    public void setPaciente(String paciente) {
        Paciente = paciente;
    }

    public void setFuncionario(Funcionario funcionario) {
        Funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Procedimento{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", DataAgendada=" + DataAgendada +
                ", Paciente=" + Paciente +
                ", Funcionario=" + Funcionario +
                '}';
    }
}
