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

    @GetMapping(value = "/listar")
    public List<Paciente> ListarPacientes(){
        return service.ListarPacientes();
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

//    @PutMapping
//    public Paciente AlterarPaciente(@RequestBody Paciente paciente){
//        return service.AlterarPaciente(paciente);
//    }
//
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
