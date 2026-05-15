package com.example.auto_pro.services;

import com.example.auto_pro.model.Cita;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public interface ICitaServicio {
    List<Cita> listarCitas();

    Cita guardarCita(Cita cita);

    Cita buscarPorId(Integer id);

    void eliminarCita(Integer id);

    List<Cita> buscarPorFecha(LocalDate fecha);

    List<Cita> buscarPorHora(LocalTime hora);

    List<Cita> buscarPorEstado(String estado);

    List<Cita> buscarPorCliente(Integer idCliente);

    List<Cita> buscarPorSucursal(Integer idSucursal);
}