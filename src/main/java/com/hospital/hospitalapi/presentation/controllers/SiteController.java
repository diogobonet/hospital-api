package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Funcionario;
import com.hospital.hospitalapi.presentation.controllers.FuncionarioController;
import com.hospital.hospitalapi.repository.repositories.FuncionarioRepository;
import com.hospital.hospitalapi.service.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteController {
    private final FuncionarioController funcionarioController;
    private final CirurgiaController cirurgiaController;
    private final ConsultaController consultaController;
    private final ExameController exameController;
    private final MedicoController medicoController;
    private final PacienteController pacienteController;
    private final RelatorioController relatorioController;

    public SiteController(
            FuncionarioController funcionarioController,
            CirurgiaController cirurgiaController,
            ConsultaController consultaController,
            ExameController exameController,
            MedicoController medicoController,
            PacienteController pacienteController,
            RelatorioController relatorioController) {
        this.funcionarioController = funcionarioController;
        this.cirurgiaController = cirurgiaController;
        this.consultaController = consultaController;
        this.exameController = exameController;
        this.medicoController = medicoController;
        this.pacienteController = pacienteController;
        this.relatorioController = relatorioController;
    }

    @GetMapping("/index")
    private String index() {
        return "/pages/Administrador/adm.html";
    }

    @GetMapping("/funcionariolista")
    private ModelAndView listagem_funcionarios() {
        List<Funcionario> listaFuncionarios = funcionarioController.ListarFuncionarios();

        ModelAndView mv = new ModelAndView("/pages/Funcionario/funcionario-list.html");
        mv.addObject("listafuncionarios", listaFuncionarios);

        return mv;
    }

    @GetMapping("/funcionariocadastro")
    private String cirurgia_funcionarios() {
        return "/pages/Funcionario/funcionario-edit.html";
    }

}