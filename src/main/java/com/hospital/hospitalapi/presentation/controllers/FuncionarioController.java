package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Funcionario;
import com.hospital.hospitalapi.service.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "funcionarios")
public class FuncionarioController {
    private final FuncionarioService service;

    @Autowired
    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping(path = "/obterporcpf/{cpf}")
    public Object ObterFuncionarioPorCpf(@PathVariable("cpf") String cpf) {
        try {
            return service.ObterFuncionarioPorCpf(cpf);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @PostMapping(path = "/criar")
    public Object CriarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            return service.CriarFuncionario(funcionario);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @DeleteMapping(path = "/removerporcpf/{cpf}")
    public void RemoverFuncionarioPorCpf(@PathVariable("cpf") String cpf) {
        service.RemoverFuncionarioPorCpf(cpf);
    }
}