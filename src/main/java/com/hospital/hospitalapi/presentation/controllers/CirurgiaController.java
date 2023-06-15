package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Cirurgia;
import com.hospital.hospitalapi.service.services.CirurgiaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cirurgia", description = "Controladora responsável pelo escopo da Cirurgia.")
@RestController
@RequestMapping(value = "cirurgias")
public class CirurgiaController {
    private final CirurgiaService service;

    @Autowired
    public CirurgiaController(CirurgiaService service) {
        this.service = service;
    }

    @GetMapping(path = "/obterporid/{id}")
    public Object ObterConsultaPorId(@PathVariable("id") Long id)
    {
        try {
            return service.ObterCirurgiaPorId(id);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping
    public List<Cirurgia> ListarConsultas()
    {
        return service.ListarCirurgias();
    }

    @PostMapping
    public Object CriarConsulta(@RequestBody Cirurgia cirurgia)
    {
        try{
            return service.CriarCirurgia(cirurgia);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    //alterar aqui

    @DeleteMapping(path = "/remover/{id}")
    public void RemoverCirurgia(@PathVariable("id") Long id)
    {
        try{
            service.RemoverCirurgia(id);
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }
}
