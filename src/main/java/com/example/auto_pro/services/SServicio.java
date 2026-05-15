package com.example.auto_pro.services;

import com.example.auto_pro.model.Servicio;
import com.example.auto_pro.repository.ServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SServicio implements ISServicio {

    @Autowired
    private ServicioRepositorio servicioRepositorio;

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepositorio.findAll();
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepositorio.save(servicio);
    }

    @Override
    public Servicio buscarPorId(Integer id) {
        return servicioRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarServicio(Integer id) {
        servicioRepositorio.deleteById(id);
    }

    @Override
    public List<Servicio> buscarPorNombre(String nombre) {
        return servicioRepositorio.findByNombreContainingIgnoreCase(nombre);
    }
}