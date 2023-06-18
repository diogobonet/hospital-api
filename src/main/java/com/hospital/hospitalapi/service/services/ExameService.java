package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Exame;
import com.hospital.hospitalapi.repository.repositories.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {
    private final ExameRepository repository;

    @Autowired
    public ExameService(ExameRepository repository) {
        this.repository = repository;
    }

    public Object ObterExamePorId(Long id){
        boolean existe = repository.existsById(id);
        if (!existe)
            throw new IllegalStateException("Exame com o Id " + id + " não existe");

        return repository.findById(id);
    }

    public List<Exame> ListarExames(){
        return repository.findAll();
    }

    public void RemoverExame(Long id) {
        boolean existe = repository.existsById(id);
        if (!existe)
            throw new IllegalStateException("Exame com o Id" + id + " não existe.");

        repository.deleteById(id);
    }
}
