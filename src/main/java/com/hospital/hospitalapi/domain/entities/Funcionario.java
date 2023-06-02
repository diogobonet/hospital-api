package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.entities.base.Pessoa;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Funcionario")
public class Funcionario extends Pessoa {
    private String Cargo;
    private double Salario;
    private boolean Ativo;
    private String CargaHoraria;
    private String CTPS;

    @OneToMany
    @JoinColumn(name = "RelatorioId")
    private List<Relatorio> RelatoriosAssinados;

    public Funcionario() {
    }

    public Funcionario(
            String nome,
            LocalDate dataNascimento,
            String sexo,
            String endereco,
            String CPF,
            String cargo,
            double salario,
            boolean ativo,
            String cargaHoraria,
            String CTPS,
            List<Relatorio> relatoriosAssinados) {
        super(
                nome,
                dataNascimento,
                sexo,
                endereco,
                CPF);
        this.Cargo = cargo;
        this.Salario = salario;
        this.Ativo = ativo;
        this.CargaHoraria = cargaHoraria;
        this.CTPS = CTPS;
        this.RelatoriosAssinados = relatoriosAssinados;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public void setAtivo(boolean ativo) {
        Ativo = ativo;
    }

    public String getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    public String getCTPS() {
        return CTPS;
    }

    public void setCTPS(String CTPS) {
        this.CTPS = CTPS;
    }

    public List<Relatorio> getRelatoriosAssinados() {
        return RelatoriosAssinados;
    }

    public void setRelatoriosAssinados(List<Relatorio> relatoriosAssinados) {
        RelatoriosAssinados = relatoriosAssinados;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "Cargo='" + Cargo + '\'' +
                ", Salario=" + Salario +
                ", Ativo=" + Ativo +
                ", CargaHoraria='" + CargaHoraria + '\'' +
                ", CTPS='" + CTPS + '\'' +
                '}';
    }
}
