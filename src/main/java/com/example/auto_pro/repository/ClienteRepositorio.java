package com.example.auto_pro.repository;

import com.example.auto_pro.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    java.util.List<Cliente> findByNombreContainingIgnoreCase(String nombre);

    java.util.List<Cliente> findByApellidoContainingIgnoreCase(String apellido);

    java.util.List<Cliente> findByCorreoContainingIgnoreCase(String correo);

    java.util.List<Cliente> findByTelefonoContainingIgnoreCase(String telefono);

    java.util.List<Cliente> findAllByOrderByNombreAsc();

    java.util.List<Cliente> findAllByOrderByNombreDesc();

    java.util.List<Cliente> findByFechaRegistroGreaterThan(LocalDate fechaRegistro);
}
