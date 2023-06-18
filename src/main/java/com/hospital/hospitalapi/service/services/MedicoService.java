package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Medico;
import com.hospital.hospitalapi.domain.enums.MedicoEspecialidadeEnum;
import com.hospital.hospitalapi.repository.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    private final MedicoRepository repository;

    @Autowired
    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public List<Medico> ListarMedicos(){
        return repository.findAll();
    }

    public Object ObterMedicoPorCrm(String crm){
        Optional<Medico> medico = repository.ObterMedicoPorCrm(crm); // faz comunicação com o repositório para retornar um medico pelo CRM dentro da base de dados
        if (!medico.isPresent())
            throw new IllegalStateException("Medico com o CRM " + crm + " não encontrado.");

        return medico;
    }

    public Object CriarMedico(Medico medico) {
        Optional<Medico> medicoPorCrm = repository.ObterMedicoPorCrm(medico.getCRM());// faz comunicação com o repositório para reportar um paciente pelo Id dentro da base de dados
        if (medicoPorCrm.isPresent())
            throw new IllegalStateException("Medico com CRM " + medicoPorCrm.get().getCRM() + " já existe na base de dados.");

        if (medico.getDataNascimento().equals(LocalDate.now()))
            throw new IllegalStateException("Data de nascimento precisa ser maior que a data atual.");

        return repository.save(medico); // pede para o repositório salvar esse ojeto na base de dados
    }

    public void RemoverMedicoPorCrm(String crm) {
        Optional<Medico> medico = repository.ObterMedicoPorCrm(crm);
        if (medico.isPresent())
            repository.delete(medico.get());
        else {
            throw new IllegalStateException("Médico com o CRM " + crm + " não existe.");
        }
    }

    public Object AlterarEspecialidade(String crm, String especialidade) {
        Medico medico = repository.ObterMedicoPorCrm(crm).orElseThrow(() -> new IllegalStateException("Médico com CRM: " + crm + " não existe."));
        if (especialidade != null)
            medico.setEspecialidade(MedicoEspecialidadeEnum.valueOf(especialidade));
        else {
            throw new IllegalStateException("Especialidade precisa ser informada.");
        }

        return medico;
    }
}
