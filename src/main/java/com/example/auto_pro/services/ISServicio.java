package com.example.auto_pro.services;

import com.example.auto_pro.model.Servicio;
import java.util.List;

public interface ISServicio {
    List<Servicio> listarServicios();

    Servicio guardarServicio(Servicio servicio);

    Servicio buscarPorId(Integer id);

    void eliminarServicio(Integer id);

    List<Servicio> buscarPorNombre(String nombre);
}