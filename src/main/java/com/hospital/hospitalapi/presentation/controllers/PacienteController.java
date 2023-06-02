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
    public Paciente CriarPaciente(@RequestBody Paciente paciente){
        service.CriarPaciente(paciente);
        return paciente;
    }
}
