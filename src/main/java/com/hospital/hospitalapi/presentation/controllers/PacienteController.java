package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Paciente;
import com.hospital.hospitalapi.service.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
    private final PacienteService service;

    @Autowired
    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public Object ObterPacientePorId(@PathVariable("id") Long id){
        try {
            return service.ObterPacientePorId(id);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping(path = "{cpf}")
    public Object ObterPacientePorCpf(@PathVariable("cpf") String cpf){
        try{
            return service.findPacienteByCpf(cpf);
        }
        catch (Exception ex){
            return ex;
        }
    }

    @GetMapping
    public List<Paciente> ListarPacientes(){
        try {
            return service.ListarPacientes();
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @PostMapping
    public Object CriarPaciente(@RequestBody Paciente paciente){
        try{
            return service.CriarPaciente(paciente);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @DeleteMapping(path = "{id}")
    public void RemoverPaciente(@PathVariable("id") Long id){
        try{
            service.RemoverPaciente(id);
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }
}
