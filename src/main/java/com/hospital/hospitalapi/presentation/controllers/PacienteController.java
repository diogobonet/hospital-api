package com.hospital.hospitalapi.presentation.controllers;

import com.hospital.hospitalapi.domain.entities.Paciente;
import com.hospital.hospitalapi.service.services.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Paciente", description = "Controladora responsável pelo escopo do paciente.")
@RestController // define que esta classe se trata de uma controladora
@RequestMapping(value = "pacientes") // define o caminho padrão da controladora, a partir daqui todas as subrotas definidas serão http://localhost:8080/swagger-ui/index.html#/pacientes/caminho-criado
public class PacienteController {
    private final PacienteService service; // faz a injeção de dependência do serviço realacionado ao paciente

    @Autowired //para contruir a dependência do serviço
    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping(path = "/obterporid/{id}") // define o caminho da requisição na API
    public Object ObterPacientePorId(@PathVariable("id") Long id) //define o parâmetro que será utilizado na requisição, definido no caminho
    {
        try {
            return service.ObterPacientePorId(id); // faz a comunicação com o serviço, fazendo referência a um método descrito para buscar um paciente pelo Id retornando este mesmo paciente no retorno da API para visualização
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping(path = "/obterporcpf/{cpf}") // define o caminho da requisição na API
    public Object ObterPacientePorCpf(@PathVariable("cpf") String cpf) //define o parâmetro que será utilizado na requisição, definido no caminho
    {
        try{
            return service.ObterPacientePorCpf(cpf);// faz a comunicação com o serviço, fazendo referência a um método descrito para obter um paciente pelo CPF retornando este mesmo paciente no retorno da API para visualização
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping(path = "/listar")
    public List<Paciente> ListarPacientes()
    {
        return service.ListarPacientes(); // faz a comunicação com o serviço, fazendo referência a um método descrito para buscar todos os pacientes retornando esta mesma lista no retorno da API para visualização
    }

    @PostMapping
    public Object CriarPaciente(@RequestBody Paciente paciente) // define que a requisição será feita pelo corpo, levando um objeto inteiro ao invés de apenas um parâmetro no caminho
    {
        try{
            return service.CriarPaciente(paciente); // faz a comunicação com o serviço, fazendo referência a um método descrito para criar um paciente retornando este mesmo paciente no retorno da API para visualização
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }
    @PutMapping(path = "/alterarstatus/{id}")
    public Object AlterarStatusPaciente(@PathVariable("id") Long id,
                                        @RequestParam(required = true) String status){
        try{
            return service.AlterarStatusPaciente(id, status);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @PutMapping(path = "/alterar/{id}")
    public Object AlterarPaciente(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String endereco){
        try{
            return service.AlterarPaciente(id, nome, endereco);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }


    @DeleteMapping(path = "/remover/{id}") // define o caminho da requisição na API
    public void RemoverPaciente(@PathVariable("id") Long id) //define o parâmetro que será utilizado na requisição, definido no caminho
    {
        try{
            service.RemoverPaciente(id); // faz a comunicação com o serviço, utilizando um método descrito para retornar um paciente
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }

    @DeleteMapping(path = "/removerporcpf/{cpf}")
    public void RemoverPacientePorCpf(@PathVariable("cpf") String cpf){
          service.RemoverPacientePorCpf(cpf);
    }
}
