package com.example.auto_pro.controller;

import com.example.auto_pro.services.ISServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class serviciocontroller {

    @Autowired
    private ISServicio servicioServicio;

    @GetMapping("/listar")
    public String listarServicios(Model model) {
        model.addAttribute("servicios", servicioServicio.listarServicios());
        return "serviciolista";
    }

}