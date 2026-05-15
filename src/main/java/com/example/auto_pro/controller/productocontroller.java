package com.example.auto_pro.controller;

import com.example.auto_pro.services.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class productocontroller {

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/listar")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoServicio.listarProductos());
        return "productolista";
    }

}