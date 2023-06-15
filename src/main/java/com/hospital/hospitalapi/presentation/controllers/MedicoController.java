package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Medico;
import com.hospital.hospitalapi.service.services.MedicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Médico", description = "Controladora responsável pelo escopo do médico.")
@RestController
@RequestMapping(value = "medicos")
public class MedicoController {
    private final MedicoService service;

    @Autowired
    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping(path = "/obterporcrm/{crm}")
    public Object ObterMedicoPorCrm(@PathVariable("crm") String crm) {
        try {
            return service.ObterMedicoPorCrm(crm);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @GetMapping
    public List<Medico> ListarMedicos() {
        return service.ListarMedicos(); // faz a comunicação com o serviço, fazendo referência a um método descrito para buscar todos os pacientes retornando esta mesma lista no retorno da API para visualização
    }


    @PostMapping(path = "/criar")
    public Object CriarMedico(@RequestBody Medico medico) // define que a requisição será feita pelo corpo, levando um objeto inteiro ao invés de apenas um parâmetro no caminho
    {
        try{
            return service.CriarMedico(medico); // faz a comunicação com o serviço, fazendo referência a um método descrito para criar um paciente retornando este mesmo paciente no retorno da API para visualização
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @DeleteMapping(path = "/removerporcrm/{crm}")
    public void RemoverMedicoPorCrm(@PathVariable("crm") String crm) {
        service.RemoverMedicoPorCrm(crm);
    }
}
