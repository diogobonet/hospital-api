package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Consulta;
import com.hospital.hospitalapi.service.services.ConsultaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Consulta", description = "Controladora responsável pelo escopo da Consulta.")
@RestController
@RequestMapping(value = "consultas")
public class ConsultaController {
    private final ConsultaService service;

    @Autowired
    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping(path = "/obterporid/{id}")
    public Object ObterConsultaPorId(@PathVariable("id") Long id)
    {
        try {
            return service.ObterConsultaPorId(id);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping
    public List<Consulta> ListarConsultas()
    {
        return service.ListarConsultas();
    }

    @PostMapping
    public Object CriarConsulta(@RequestBody Consulta consulta)
    {
        try{
            return service.CriarConsulta(consulta);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    //alterar aqui

    @DeleteMapping(path = "/remover/{id}")
    public void RemoverConsulta(@PathVariable("id") Long id)
    {
        try{
            service.RemoverConsulta(id);
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }
}
