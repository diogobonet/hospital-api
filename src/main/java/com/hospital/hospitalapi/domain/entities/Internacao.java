package com.hospital.hospitalapi.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Internacao")
public class Internacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "PacienteId")
    private Paciente Paciente;
    private LocalDateTime DataEntrada;
    private LocalDateTime DataSaida;

    @ManyToOne
    @JoinColumn(name = "ProntuarioId")
    private Prontuario Prontuario;

    @ManyToOne
    @JoinColumn(name = "MedicoId")
    private Medico MedicoResponsavel;

    @ManyToOne
    @JoinColumn(name = "FuncionarioId")
    private Funcionario Funcionario;

    public Internacao() {
    }

    public Internacao(
            Paciente paciente,
            LocalDateTime dataEntrada,
            LocalDateTime dataSaida,
            Prontuario prontuario,
            Medico medicoResponsavel,
            Funcionario funcionario) {
        this.Paciente = paciente;
        this.DataEntrada = dataEntrada;
        this.DataSaida = dataSaida;
        this.Prontuario = prontuario;
        this.MedicoResponsavel = medicoResponsavel;
        this.Funcionario = funcionario;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Prontuario getProntuario() {
        return Prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        Prontuario = prontuario;
    }

    public Paciente getPaciente() {
        return Paciente;
    }

    public void setPaciente(Paciente paciente) {
        Paciente = paciente;
    }

    public LocalDateTime getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        DataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return DataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        DataSaida = dataSaida;
    }

    public Medico getMedicoResponsavel() {
        return MedicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        MedicoResponsavel = medicoResponsavel;
    }

    public com.hospital.hospitalapi.domain.entities.Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(com.hospital.hospitalapi.domain.entities.Funcionario funcionario) {
        Funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Internacao{" +
                "Paciente=" + Paciente +
                ", DataEntrada=" + DataEntrada +
                ", DataSaida=" + DataSaida +
                ", Prontuario=" + Prontuario +
                ", MedicoResponsavel=" + MedicoResponsavel +
                ", Funcionario=" + Funcionario +
                '}';
    }
}
