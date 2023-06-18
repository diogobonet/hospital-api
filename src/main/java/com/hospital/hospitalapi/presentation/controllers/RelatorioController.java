package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Relatorio;
import com.hospital.hospitalapi.service.services.MedicoService;
import com.hospital.hospitalapi.service.services.RelatorioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Relatório", description = "Controladora responsável pelo escopo de relatórios.")
@RestController
@RequestMapping(value = "relatorios")
public class RelatorioController {

    private final RelatorioService service;

    @Autowired
    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @GetMapping(path = "/listar")
    public List<Relatorio> ListarRelatorios(){
        return service.ListarRelatorios();
    }

    @GetMapping(path = "/buscar/{id}")
    public Object ObterRelatorioPorId(@PathVariable("id") Long id){
        try {
            return service.ObterRelatorioPorId(id);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }
}
