package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.*;

import com.hospital.hospitalapi.domain.enums.TipoExameEnum;
import com.hospital.hospitalapi.service.services.FuncionarioService;
import com.hospital.hospitalapi.service.services.MedicoService;
import com.hospital.hospitalapi.service.services.PacienteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Funcionário", description = "Controladora responsável pelo escopo do funcionário.")
@RestController
@RequestMapping(value = "funcionarios")
public class FuncionarioController {
    private final FuncionarioService service;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    @Autowired
    public FuncionarioController(FuncionarioService service, MedicoService medicoService, PacienteService pacienteService) {
        this.service = service;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
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
    public Object CriarCirurgia(@RequestBody CirurgiaRequest cirurgiaRequest) {
        Object medico = medicoService.ObterMedicoPorCrm(cirurgiaRequest.getCrm());
        Medico medicoConvertido = (Medico) medico;

        Object paciente = pacienteService.ObterPacientePorCpf(cirurgiaRequest.getCpf());
        Paciente pacienteConvertido = (Paciente) paciente;
        String nomePaciente = pacienteConvertido.getNome();

        LocalDate dataAgendada = cirurgiaRequest.getDataAgendada();
        String nome_cirurgia = cirurgiaRequest.getNome();
        String observacoes = cirurgiaRequest.getObservacoes();

        Cirurgia cirurgia = new Cirurgia(dataAgendada, nome_cirurgia, nomePaciente, medicoConvertido, observacoes);
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
    public Object CriarExame(@RequestBody ExameRequest exameRequest) {
        Object paciente = pacienteService.ObterPacientePorCpf(exameRequest.getCpf());
        Paciente pacienteConvertido = (Paciente) paciente;
        String nomePaciente = pacienteConvertido.getNome();

        LocalDate dataAgendada = exameRequest.getDataAgendada();
        TipoExameEnum tipoExame = exameRequest.getTipoExame();

        Exame exame = new Exame(dataAgendada, "Exame", nomePaciente, tipoExame);
        try {
            return service.CriarExame(exame);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
