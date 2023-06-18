package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Cirurgia;
import com.hospital.hospitalapi.domain.entities.Consulta;
import com.hospital.hospitalapi.domain.entities.Exame;
import com.hospital.hospitalapi.domain.entities.Funcionario;
import com.hospital.hospitalapi.service.services.FuncionarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Funcionário", description = "Controladora responsável pelo escopo do funcionário.")
@RestController
@RequestMapping(value = "funcionarios")
public class FuncionarioController {
    private final FuncionarioService service;

    @Autowired
    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping(path = "/listar")
    public List<Funcionario> ListarFuncionarios() {
        return service.ListarFuncionarios();
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

    @PutMapping(path = "/alterarsalario/{cpf}")
    public Object AlterarSalarioFuncionario(@PathVariable("cpf") String cpf,
                                            @RequestParam(required = true) double salario) {
        try {
            return service.AlterarSalarioFuncionario(cpf, salario);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @DeleteMapping(path = "/removerporcpf/{cpf}")
    public void RemoverFuncionarioPorCpf(@PathVariable("cpf") String cpf) {
        service.RemoverFuncionarioPorCpf(cpf);
    }

    @PostMapping("cirurgias/criar")
    public Object CriarCirurgia(@RequestBody Cirurgia cirurgia) {
        try {
            return service.CriarCirurgia(cirurgia);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @PostMapping("consultas/criar")
    public Object CriarConsulta(@RequestBody Consulta consulta) {
        try {
            return service.CriarConsulta(consulta);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @PostMapping("exames/criar")
    public Object CriarExame(@RequestBody Exame exame)
    {
        try{
            return service.CriarExame(exame);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }
}
