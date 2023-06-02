package com.hospital.hospitalapi.domain.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany
    @JoinColumn(name = "RelatorioId")
    private List<Relatorio> Historico;

    @OneToMany
    @JoinColumn(name = "HistoricoInternacao")
    private List<Internacao> HistoricoInternacao;

    @OneToOne
    @JoinColumn(name = "PacienteId")
    private Paciente Paciente;

    public Prontuario() {
    }

    public Prontuario(
            List<Relatorio> historico,
            List<Internacao> historicoInternacao,
            Paciente paciente) {
        this.Historico = historico;
        this.HistoricoInternacao = historicoInternacao;
        this.Paciente = paciente;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Relatorio> getHistorico() {
        return Historico;
    }

    public void setHistorico(List<Relatorio> historico) {
        Historico = historico;
    }

    public List<Internacao> getHistoricoInternacao() {
        return HistoricoInternacao;
    }

    public void setHistoricoInternacao(List<Internacao> historicoInternacao) {
        HistoricoInternacao = historicoInternacao;
    }

    public com.hospital.hospitalapi.domain.entities.Paciente getPaciente() {
        return Paciente;
    }

    public void setPaciente(com.hospital.hospitalapi.domain.entities.Paciente paciente) {
        Paciente = paciente;
    }

    @Override
    public String toString() {
        return "Prontuario{" +
                "Historico=" + Historico +
                ", HistoricoInternacao=" + HistoricoInternacao +
                ", Paciente=" + Paciente +
                '}';
    }
}
