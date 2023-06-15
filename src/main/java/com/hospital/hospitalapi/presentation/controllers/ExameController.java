package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Exame;
import com.hospital.hospitalapi.service.services.ExameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Exame", description = "Controladora responsável pelo escopo do Exame.")
@RestController
@RequestMapping(value = "exames")
public class ExameController {
    private final ExameService service;

    @Autowired
    public ExameController(ExameService service) {
        this.service = service;
    }

    @GetMapping(path = "/obterporid/{id}")
    public Object ObterExamePorId(@PathVariable("id") Long id)
    {
        try {
            return service.ObterExamePorId(id);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping
    public List<Exame> ListarExames()
    {
        return service.ListarExames();
    }

    @PostMapping
    public Object CriarExame(@RequestBody Exame exame)
    {
        try{
            return service.CriarExame(exame);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @DeleteMapping(path = "/remover/{id}")
    public void RemoverExame(@PathVariable("id") Long id)
    {
        try{
            service.RemoverExame(id);
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }
}
