package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SiteController {
    private final CirurgiaController cirurgiaController;
    private final ConsultaController consultaController;
    private final ExameController exameController;
    private final FuncionarioController funcionarioController;
    private final MedicoController medicoController;
    private final PacienteController pacienteController;

    @Autowired
    public SiteController(
            CirurgiaController cirurgiaController,
            ConsultaController consultaController,
            ExameController exameController,
            FuncionarioController funcionarioController,
            MedicoController medicoController,
            PacienteController pacienteController,
            RelatorioController relatorioController
    ){
        this.cirurgiaController = cirurgiaController;
        this.consultaController = consultaController;
        this.exameController = exameController;
        this.funcionarioController = funcionarioController;
        this.medicoController = medicoController;
        this.pacienteController = pacienteController;
    }

    @GetMapping("/index")
    private String index() {
        return "/pages/Administrador/adm.html";
    }


    //---- Parte das CIRURGIAS ----
    @GetMapping("/cirurgia/lista")
    private ModelAndView listagem_cirurgias() {
        List<Cirurgia> listaCirurgia = cirurgiaController.ListarCirurgia();

        ModelAndView mv = new ModelAndView("/pages/Cirurgia/cirurgia-list.html");
        mv.addObject("listacirurgia", listaCirurgia);

        return mv;
    }
    @GetMapping("/cirurgia/cadastro")
    private ModelAndView cadastrar_cirurgia() {
        List<Medico> listaMedicos = medicoController.ListarMedicos();
        List<Paciente> listaPacientes = pacienteController.ListarPacientes();

        ModelAndView mv = new ModelAndView("/pages/Cirurgia/cirurgia-edit.html");
        mv.addObject("listamedicos", listaMedicos);
        mv.addObject("listapacientes", listaPacientes);

        return mv;
    }
    @PostMapping("/cirurgia/cadastrar")
    private String salvarCirurgia(CirurgiaRequest cirurgia) {
        funcionarioController.CriarCirurgia(cirurgia);
        return "redirect:/cirurgia/lista";
    }
    @GetMapping("/cirurgia/apagar/{id}")
    private String removerCirurgia(@PathVariable("id") Long id){
        cirurgiaController.RemoverCirurgia(id);
        return "redirect:/cirurgia/lista";
    }


    //---- Parte das CONSULTAS ----
    @GetMapping("/consulta/lista")
    private ModelAndView listagem_consultas() {
        List<Consulta> listaConsulta = consultaController.ListarConsultas();

        ModelAndView mv = new ModelAndView("/pages/Consulta/consulta-list.html");
        mv.addObject("listaconsulta", listaConsulta);

        return mv;
    }
    @GetMapping("/consulta/cadastro")
    private String cadastrar_consulta() {
        return "/pages/Consulta/consulta-edit.html";
    }
    @PostMapping("/consulta/cadastrar")
    private String salvarConsulta(Consulta consulta) {
        funcionarioController.CriarConsulta(consulta);
        return "redirect:/consulta/lista";
    }
    @GetMapping("/consulta/apagar/{id}")
    private String removerConsulta(@PathVariable("id") Long id){
        consultaController.RemoverConsulta(id);
        return "redirect:/consulta/lista";
    }


    //---- Parte dos EXAMES ----
    @GetMapping("/exame/lista")
    private ModelAndView listagem_exames() {
        List<Exame> listaExame = exameController.ListarExames();

        ModelAndView mv = new ModelAndView("/pages/Exame/exame-list.html");
        mv.addObject("listaexame", listaExame);

        return mv;
    }
    @GetMapping("/exame/cadastro")
    private ModelAndView cadastrar_exame() {
        List<Paciente> listaPacientes = pacienteController.ListarPacientes();

        ModelAndView mv = new ModelAndView("/pages/Exame/exame-edit.html");
        mv.addObject("listapacientes", listaPacientes);

        return mv;
    }
    @PostMapping("/exame/cadastrar")
    private String salvarExame(ExameRequest exameRequest) {
        funcionarioController.CriarExame(exameRequest);
        return "redirect:/exame/lista";
    }
    @GetMapping("/exame/apagar/{id}")
    private String removerExame(@PathVariable("id") Long id){
        exameController.RemoverExame(id);
        return "redirect:/exame/lista";
    }


    //---- Parte dos FUNCIONÁRIOS ----
    @GetMapping("/funcionario/lista")
    private ModelAndView listagem_funcionarios() {
        List<Funcionario> listaFuncionarios = funcionarioController.ListarFuncionarios();

        ModelAndView mv = new ModelAndView("/pages/Funcionario/funcionario-list.html");
        mv.addObject("listafuncionarios", listaFuncionarios);

        return mv;
    }
    @GetMapping("/funcionario/cadastro")
    private String cadastrar_funcionarios() {
        return "/pages/Funcionario/funcionario-edit.html";
    }
    @PostMapping("/funcionario/cadastrar")
    private String salvarFuncionario(Funcionario func) {
        funcionarioController.CriarFuncionario(func);
        return "redirect:/funcionario/lista";
    }
    @GetMapping("/funcionario/apagar/{cpf}")
    private String removerFuncionario(@PathVariable("cpf") String cpf){
        funcionarioController.RemoverFuncionarioPorCpf(cpf);
        return "redirect:/funcionario/lista";
    }


    //---- Parte dos MÉDICOS ----
    @GetMapping("/medico/lista")
    private ModelAndView listagem_medicos() {
        List<Medico> listaMedico = medicoController.ListarMedicos();

        ModelAndView mv = new ModelAndView("/pages/medico/medico-list.html");
        mv.addObject("listamedicos", listaMedico);

        return mv;
    }
    @GetMapping("/medico/cadastro")
    private String cadastrar_medicos() {
        return "/pages/Medico/medico-edit.html";
    }
    @PostMapping("/medico/cadastrar")
    private String salvarMedico(Medico medic) {
        medicoController.CriarMedico(medic);
        return "redirect:/medico/lista";
    }
    @GetMapping("/medico/apagar/{crm}")
    private String removerMedico(@PathVariable("crm") String crm){
        medicoController.RemoverMedicoPorCrm(crm);
        return "redirect:/medico/lista";
    }


    //---- Parte dos PACIENTES ----
    @GetMapping("/paciente/lista")
    private ModelAndView listagem_pacientes() {
        List<Paciente> listaPaciente = pacienteController.ListarPacientes();

        ModelAndView mv = new ModelAndView("/pages/Paciente/paciente-list.html");
        mv.addObject("listapacientes", listaPaciente);

        return mv;
    }
    @GetMapping("/paciente/cadastro")
    private String cadastrar_paciente() {
        return "/pages/Paciente/paciente-edit.html";
    }
    @PostMapping("/paciente/cadastrar")
    private String salvarPaciente(Paciente paciente) {
        pacienteController.CriarPaciente(paciente);
        return "redirect:/paciente/lista";
    }
    @GetMapping("/paciente/apagar/{cpf}")
    private String removerPaciente(@PathVariable("cpf") String cpf){
        pacienteController.RemoverPacientePorCpf(cpf);
        return "redirect:/paciente/lista";
    }
}