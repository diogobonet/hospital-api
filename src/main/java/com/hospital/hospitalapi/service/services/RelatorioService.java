package com.hospital.hospitalapi.service.services;
import com.hospital.hospitalapi.repository.repositories.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.hospitalapi.domain.entities.Relatorio;

import java.util.List;

@Service
public class RelatorioService {

    private final RelatorioRepository repository;
    @Autowired
    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

    public List<Relatorio> ListarRelatorios() {
        return repository.findAll();
    }

    public Object ObterRelatorioPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Relatório com Id " + id + " não existe."));
    }
}
