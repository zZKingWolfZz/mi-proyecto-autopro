package com.example.auto_pro.services;

import com.example.auto_pro.model.Cliente;

import java.math.BigDecimal;
import java.util.List;

public interface IClienteServicio {
    List<Cliente> listarClientes();

    Cliente guardarCliente(Cliente cliente);

    Cliente buscarPorId(Integer id);

    void eliminarCliente(Integer id);

    List<Cliente> buscarPorNombre(String nombre);

    List<Cliente> buscarPorApellido(String apellido);

    List<Cliente> buscarPorCorreo(String correo);

    List<Cliente> buscarPorTelefono(String telefono);

    List<Cliente> buscarPorFechaRegistro(java.time.LocalDate fechaRegistro);
}