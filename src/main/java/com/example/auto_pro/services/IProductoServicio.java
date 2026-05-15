package com.example.auto_pro.services;

import com.example.auto_pro.model.Producto;

import java.math.BigDecimal;
import java.util.List;

public interface IProductoServicio {
    List<Producto> listarProductos();

    Producto guardarProducto(Producto producto);

    Producto buscarPorId(Integer id);

    void eliminarProducto(Integer id);

    List<Producto> buscarPorNombre(String nombre);

    List<Producto> buscarPorPrecioMayorQue(BigDecimal precio);

    List<Producto> buscarPorStockMenorQue(Integer limite);

    List<Producto> buscarPorIdSucursal(Integer idSucursal);
}