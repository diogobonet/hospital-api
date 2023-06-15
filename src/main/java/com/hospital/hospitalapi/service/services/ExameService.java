package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Exame;
import com.hospital.hospitalapi.repository.repositories.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Object CriarExame(Exame exame) {
        Optional<Exame> consultaPorId = repository.findById(exame.getId());
        if (consultaPorId.isPresent())
            throw new IllegalStateException("Exame com id " + consultaPorId.get().getId() + "já existe na base de dados.");

        return repository.save(exame);
    }

    public void RemoverExame(Long id) {
        boolean existe = repository.existsById(id);
        if (!existe)
            throw new IllegalStateException("Exame com o Id" + id + " não existe.");

        repository.deleteById(id);
    }
}
