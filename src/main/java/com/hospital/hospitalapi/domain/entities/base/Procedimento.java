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
    private LocalDate DataAgendada;

    @ManyToOne
    @JoinColumn(name = "PacienteId")
    private Paciente Paciente;

    @OneToOne
    @JoinColumn(name = "FuncionarioId")
    private Funcionario Funcionario;

    public Procedimento() {
    }

    public Procedimento(
            LocalDate dataAgendada,
            Paciente paciente,
            Funcionario funcionario) {
        this.DataAgendada = dataAgendada;
        this.Paciente = paciente;
        this.Funcionario = funcionario;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public LocalDate getDataAgendada() {
        return DataAgendada;
    }

    public Paciente getPaciente() {
        return Paciente;
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }


    public void setDataAgendada(LocalDate dataAgendada) {
        DataAgendada = dataAgendada;
    }

    public void setPaciente(Paciente paciente) {
        Paciente = paciente;
    }

    public void setFuncionario(Funcionario funcionario) {
        Funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Procedimento{" +
                ", DataAgendada=" + DataAgendada +
                ", Paciente=" + Paciente +
                ", Funcionario=" + Funcionario +
                '}';
    }
}
