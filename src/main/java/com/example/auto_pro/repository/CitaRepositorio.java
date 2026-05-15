package com.example.auto_pro.repository;

import com.example.auto_pro.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Integer> {
    java.util.List<Cita> findByHora(LocalTime hora);

    java.util.List<Cita> findByEstadoContainingIgnoreCase(String estado);

    java.util.List<Cita> findByFechaCitaBetween(LocalDate min, LocalDate max);

    java.util.List<Cita> findAllByOrderByFechaCitaAsc();

    java.util.List<Cita> findAllByOrderByFechaCitaDesc();

    java.util.List<Cita> findByHoraGreaterThan(LocalTime hora);

    java.util.List<Cita> findByIdCliente(Integer idCliente);

    java.util.List<Cita> findByIdSucursal(Integer idSucursal);

    java.util.List<Cita> findByFechaCita(LocalDate fecha);

}