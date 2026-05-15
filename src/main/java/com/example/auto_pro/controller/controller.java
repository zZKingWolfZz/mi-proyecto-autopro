package com.example.auto_pro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.auto_pro.model.Producto;
import com.example.auto_pro.services.IProductoServicio;
import com.example.auto_pro.services.ISServicio;
import com.example.auto_pro.model.Servicio;
import com.example.auto_pro.model.Cliente;
import com.example.auto_pro.services.IClienteServicio;
import com.example.auto_pro.model.Cita;
import com.example.auto_pro.services.ICitaServicio;

@Controller
public class controller { // o el nombre que tenga tu controlador principal

    @Autowired
    private IProductoServicio productoServicio;

    @Autowired
    private ISServicio servicioServicio;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("servicios", servicioServicio.listarServicios());
        List<Servicio> lista2 = servicioServicio.listarServicios();
        lista2.forEach(item -> System.out.println("Dato de BD: " + item));
        model.addAttribute("datos2", lista2);
        return "index";
    }

    @GetMapping("/productos")
    public String productos(@RequestParam(value = "palabraClave", required = false) String palabraClave, Model model) {
        if (palabraClave != null && !palabraClave.isEmpty()) {
            model.addAttribute("productos", productoServicio.buscarPorNombre(palabraClave));
        } else {
            model.addAttribute("productos", productoServicio.listarProductos());
        }
        model.addAttribute("palabraClave", palabraClave);
        model.addAttribute("producto", new Producto());
        return "dasboard/productos";
    }

    @PostMapping("/productos/guardar")
    public String guardar(@ModelAttribute("producto") Producto producto) {
        productoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("producto", productoServicio.buscarPorId(id));
        model.addAttribute("productos", productoServicio.listarProductos());
        return "dasboard/productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoServicio.eliminarProducto(id);
        return "redirect:/productos";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        model.addAttribute("productos", productoServicio.listarProductos());
        List<Producto> lista = productoServicio.listarProductos();
        lista.forEach(item -> System.out.println("Dato de BD: " + item));
        model.addAttribute("datos", lista);
        return "catalogo";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/logup")
    public String logup(Model model) {
        return "logup";
    }

    @GetMapping("/configuracion")
    public String configuracion(Model model) {
        return "dasboard/configuracion";
    }

    @GetMapping("/ventas")
    public String ventas(Model model) {
        return "dasboard/ventas";
    }

    @GetMapping("/reportes")
    public String reportes(Model model) {
        return "dasboard/reportes";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dasboard/dashboard";
    }

    // Cliente
    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public String clientes(@RequestParam(value = "palabraClave", required = false) String palabraClave, Model model) {
        if (palabraClave != null && !palabraClave.isEmpty()) {
            model.addAttribute("clientes", clienteServicio.buscarPorNombre(palabraClave));
        } else {
            model.addAttribute("clientes", clienteServicio.listarClientes());
        }
        model.addAttribute("palabraClave", palabraClave);
        model.addAttribute("cliente", new Cliente());

        return "dasboard/clientes";
    }

    @PostMapping("/clientes/guardar")
    public String guardar(@ModelAttribute("cliente") Cliente cliente) {
        clienteServicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String ClienteEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("cliente", clienteServicio.buscarPorId(id));
        model.addAttribute("clientes", clienteServicio.listarClientes());
        return "dasboard/clientes";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        clienteServicio.eliminarCliente(id);
        return "redirect:/clientes";
    }

    // Cita
    @Autowired
    private ICitaServicio citaServicio;

    @GetMapping("/citas")
    public String citas(@RequestParam(value = "palabraClave", required = false) String palabraClave, Model model) {
        if (palabraClave != null && !palabraClave.isEmpty()) {
            model.addAttribute("citas", citaServicio.buscarPorEstado(palabraClave));
        } else {
            model.addAttribute("citas", citaServicio.listarCitas());
        }
        model.addAttribute("palabraClave", palabraClave);
        model.addAttribute("clientes", clienteServicio.listarClientes());
        model.addAttribute("cita", new Cita());

        return "dasboard/citas";
    }

    @PostMapping("/citas/guardar")
    public String guardar(@ModelAttribute("cita") Cita cita) {
        citaServicio.guardarCita(cita);
        return "redirect:/citas";
    }

    @GetMapping("/citas/editar/{id}")
    public String CitaEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("cita", citaServicio.buscarPorId(id));
        model.addAttribute("citas", citaServicio.listarCitas());
        model.addAttribute("clientes", clienteServicio.listarClientes());
        return "dasboard/citas";
    }

    @GetMapping("/citas/eliminar/{id}")
    public String eliminarCita(@PathVariable Integer id) {
        citaServicio.eliminarCita(id);
        return "redirect:/citas";
    }

}
