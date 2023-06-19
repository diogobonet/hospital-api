package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Cirurgia;
import com.hospital.hospitalapi.domain.entities.Funcionario;
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
    public Object ObterCirurgiaPorId(@PathVariable("id") Long id)
    {
        try {
            return service.ObterCirurgiaPorId(id);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @PostMapping(path = "/criar")
    public Object CriarCirurgia(@RequestBody Cirurgia cirurgia) {
        try {
            return service.CriarCirurgia(cirurgia);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @GetMapping(path = "/listar")
    public List<Cirurgia> ListarCirurgia()
    {
        return service.ListarCirurgias();
    }


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
