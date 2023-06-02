package com.hospital.hospitalapi.domain.entities.base;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Nome;
    private LocalDate DataNascimento;
    private String Sexo;
    private String Endereco;
    private String CPF;

    public Pessoa() {
    }

    public Pessoa(
            String nome,
            LocalDate dataNascimento,
            String sexo,
            String endereco,
            String CPF) {
        this.Nome = nome;
        this.DataNascimento = dataNascimento;
        this.Sexo = sexo;
        this.Endereco = endereco;
        this.CPF = CPF;
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

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome='" + Nome + '\'' +
                ", DataNascimento=" + DataNascimento +
                ", Sexo='" + Sexo + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
