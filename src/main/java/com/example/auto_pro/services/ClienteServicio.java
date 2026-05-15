package com.example.auto_pro.services;

import com.example.auto_pro.model.Cliente;
import com.example.auto_pro.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepositorio.deleteById(id);
    }

    @Override
    public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepositorio.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Cliente> buscarPorApellido(String apellido) {
        return clienteRepositorio.findByApellidoContainingIgnoreCase(apellido);
    }

    @Override
    public List<Cliente> buscarPorCorreo(String correo) {
        return clienteRepositorio.findByCorreoContainingIgnoreCase(correo);
    }

    @Override
    public List<Cliente> buscarPorTelefono(String telefono) {
        return clienteRepositorio.findByTelefonoContainingIgnoreCase(telefono);
    }

    @Override
    public List<Cliente> buscarPorFechaRegistro(java.time.LocalDate fechaRegistro) {
        return clienteRepositorio.findByFechaRegistroGreaterThan(fechaRegistro);
    }
}
