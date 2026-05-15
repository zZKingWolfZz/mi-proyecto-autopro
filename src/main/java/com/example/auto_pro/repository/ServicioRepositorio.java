package com.example.auto_pro.repository;

import com.example.auto_pro.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Integer> {
    java.util.List<Servicio> findByNombreContainingIgnoreCase(String nombre);

}