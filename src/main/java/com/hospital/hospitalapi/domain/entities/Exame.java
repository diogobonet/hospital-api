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
    private String Resultado = "Não realizado.";

    public Exame(
            LocalDate dataAgendada,
            String nome,
            String paciente,
            TipoExameEnum tipo) {
        super(
                dataAgendada,
                nome,
                paciente);
        this.Tipo = tipo;
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
