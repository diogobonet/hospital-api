package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.entities.base.Procedimento;
import com.hospital.hospitalapi.domain.enums.TipoExameEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Exame")
public class Exame extends Procedimento {

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo")
    private TipoExameEnum Tipo;
    private String Resultado;

    public Exame(
            LocalDate dataAgendada,
            String nome,
            String paciente,
            Funcionario funcionario,
            TipoExameEnum tipo,
            String resultado) {
        super(
                dataAgendada,
                nome,
                paciente,
                funcionario);
        this.Tipo = tipo;
        this.Resultado = resultado;
    }

    public TipoExameEnum getTipo() {
        return Tipo;
    }

    public void setTipo(TipoExameEnum tipo) {
        Tipo = tipo;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }

    @Override
    public String toString() {
        return "Exame{" +
                "Tipo=" + Tipo +
                ", Resultado='" + Resultado + '\'' +
                '}';
    }
}
