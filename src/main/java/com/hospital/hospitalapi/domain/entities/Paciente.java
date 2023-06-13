package com.hospital.hospitalapi.domain.entities;

import com.hospital.hospitalapi.domain.entities.base.Pessoa;
import com.hospital.hospitalapi.domain.enums.PacienteStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Paciente")
public class Paciente extends Pessoa {
    private boolean PlanoSaude;
        private List<String> Alergias;
        private boolean Vivo;

        @Enumerated(EnumType.STRING)
        @Column(name= "Status")
        private PacienteStatusEnum Status;

    public Paciente (){

        }

    public Paciente(
                String nome,
                LocalDate dataNascimento,
                String sexo,
                String endereco,
                String CPF,
        boolean planoSaude,
        List<String> alergias,
        boolean vivo,
        PacienteStatusEnum status) {
            super(
                    nome,
                    dataNascimento,
                    sexo,
                    endereco,
                    CPF);
            this.PlanoSaude = planoSaude;
            this.Alergias = alergias;
            this.Vivo = vivo;
        this.Status = status;
    }

    public boolean isPlanoSaude() {
        return PlanoSaude;
    }

    public void setPlanoSaude(boolean planoSaude) {
        PlanoSaude = planoSaude;
    }

    public List<String> getAlergias() {
        return Alergias;
    }

    public void setAlergias(List<String> alergias) {
        Alergias = alergias;
    }

    public boolean isVivo() {
        return Vivo;
    }

    public void setVivo(boolean vivo) {
        Vivo = vivo;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "PlanoSaude=" + PlanoSaude +
                ", Alergias=" + Alergias +
                ", Vivo=" + Vivo +
                ", Status=" + Status +
                '}';
    }

    public PacienteStatusEnum getStatus() {
        return Status;
    }

    public void setStatus(PacienteStatusEnum status) {
        Status = status;
    }
}
