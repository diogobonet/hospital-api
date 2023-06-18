package com.hospital.hospitalapi.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestehtmlController {
    @GetMapping("/adm")
    public String create(){
        return "/pages/Administrador/adm";
    }
}
