package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.enums.TipoExameEnum;

import java.time.LocalDate;

public class ExameRequest {
    public LocalDate dataAgendada;
    public String Cpf;
    public TipoExameEnum tipoExame;

    public ExameRequest(){}

    public ExameRequest(LocalDate dataAgendada, String cpf, TipoExameEnum tipoExame){
        this.dataAgendada = dataAgendada;
        this.Cpf = cpf;
        this.tipoExame = tipoExame;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public String getCpf() {
        return Cpf;
    }

    public TipoExameEnum getTipoExame() {
        return tipoExame;
    }

    @Override
    public String toString() {
        return "ExameRequest{" +
                ", dataAgendada=" + dataAgendada +
                ", Cpf='" + Cpf + '\'' +
                ", tipoExame='" + tipoExame + '\'' +
                '}';
    }
}
