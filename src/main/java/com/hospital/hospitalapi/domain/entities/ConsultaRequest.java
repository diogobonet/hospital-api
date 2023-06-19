package com.hospital.hospitalapi.domain.entities;

import java.time.LocalDate;

public class ConsultaRequest {
    public String Crm;
    public String Cpf;
    public LocalDate dataAgendada;
    public String nome;
    public String observacoes;


    public ConsultaRequest(String crm, String cpf) {
        this.Cpf = cpf;
        this.Crm = crm;
    }

    public String getCpf() {
        return Cpf;
    }

    public String getCrm(){
        return Crm;
    }

    public void setCpf(String cpf){
        Cpf = cpf;
    }

    public void setCrm(String crm){
        Crm = crm;
    }

    public LocalDate getDataAgendada() {return dataAgendada;}

    public String getNome() {return nome;}

    public String getObservacoes() {return observacoes;}

    @Override
    public String toString() {
        return "CirurgiaRequest{" +
                "Cpf=" + Cpf +
                ", Crm=" + Crm  +
                '}';
    }
}
