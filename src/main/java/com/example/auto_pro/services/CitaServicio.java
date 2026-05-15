package com.example.auto_pro.services;

import com.example.auto_pro.model.Cita;
import com.example.auto_pro.repository.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class CitaServicio implements ICitaServicio {

    @Autowired
    private CitaRepositorio citaRepositorio;

    @Override
    public List<Cita> listarCitas() {
        return citaRepositorio.findAll();
    }

    @Override
    public Cita guardarCita(Cita cita) {
        return citaRepositorio.save(cita);
    }

    @Override
    public Cita buscarPorId(Integer id) {
        return citaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarCita(Integer id) {
        citaRepositorio.deleteById(id);
    }

    @Override
    public List<Cita> buscarPorFecha(LocalDate fecha) {
        return citaRepositorio.findByFechaCita(fecha);
    }

    @Override
    public List<Cita> buscarPorHora(LocalTime hora) {
        return citaRepositorio.findByHora(hora);
    }

    @Override
    public List<Cita> buscarPorEstado(String estado) {
        return citaRepositorio.findByEstadoContainingIgnoreCase(estado);
    }

    @Override
    public List<Cita> buscarPorCliente(Integer idCliente) {
        return citaRepositorio.findByIdCliente(idCliente);
    }

    @Override
    public List<Cita> buscarPorSucursal(Integer idSucursal) {
        return citaRepositorio.findByIdSucursal(idSucursal);
    }
}
