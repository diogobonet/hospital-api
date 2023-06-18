package com.hospital.hospitalapi.service.services;

import com.hospital.hospitalapi.domain.entities.Consulta;
import com.hospital.hospitalapi.repository.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;

    @Autowired
    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Object ObterConsultaPorId(Long id){
        boolean existe = repository.existsById(id);
        if (!existe)
            throw new IllegalStateException("Consulta com o Id " + id + " não existe");

        return repository.findById(id);
    }

    public List<Consulta> ListarConsultas(){
        return repository.findAll();
    }



    public void RemoverConsulta(Long id) {
        boolean existe = repository.existsById(id);
        if (!existe)
            throw new IllegalStateException("Consulta com o Id" + id + " não existe.");

        repository.deleteById(id);
    }
}
