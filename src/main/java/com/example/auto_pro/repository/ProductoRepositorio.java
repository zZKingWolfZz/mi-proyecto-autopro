package com.example.auto_pro.repository;

import com.example.auto_pro.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    java.util.List<Producto> findByNombreContainingIgnoreCase(String nombre);

    java.util.List<Producto> findByStockLessThan(Integer limite);

    java.util.List<Producto> findByStockGreaterThan(Integer minimo);

    java.util.List<Producto> findByPrecioBetween(BigDecimal min, BigDecimal max);

    java.util.List<Producto> findAllByOrderByPrecioAsc();

    java.util.List<Producto> findAllByOrderByPrecioDesc();

    java.util.List<Producto> findByPrecioGreaterThan(BigDecimal precio);

    java.util.List<Producto> findByIdSucursal(Integer idSucursal);

}