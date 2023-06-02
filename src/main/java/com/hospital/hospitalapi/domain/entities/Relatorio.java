package com.hospital.hospitalapi.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Relatorio")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "ProcedimentoId")
    private RelatorioProcedimento RelatorioProcedimento;

    @ManyToOne
    @JoinColumn(name = "FuncionarioId")
    private Funcionario Funcionario;

    private String Descricao;

    public Relatorio() {
    }

    public Relatorio(
            RelatorioProcedimento relatorioProcedimento,
            String descricao,
            Funcionario funcionario
            ) {
        this.RelatorioProcedimento = relatorioProcedimento;
        this.Descricao = descricao;
        this.Funcionario = funcionario;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public RelatorioProcedimento getProcedimento() {
        return RelatorioProcedimento;
    }

    public void setProcedimento(RelatorioProcedimento relatorioProcedimento) {
        RelatorioProcedimento = relatorioProcedimento;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        Funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "RelatorioProcedimento=" + RelatorioProcedimento +
                ", Descricao='" + Descricao + '\'' +
                ", Funcionario=" + Funcionario +
                '}';
    }
}
