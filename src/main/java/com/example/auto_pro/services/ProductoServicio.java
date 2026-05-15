package com.example.auto_pro.services;

import com.example.auto_pro.model.Producto;
import com.example.auto_pro.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto buscarPorId(Integer id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepositorio.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Producto> buscarPorPrecioMayorQue(BigDecimal precio) {
        return productoRepositorio.findByPrecioGreaterThan(precio);
    }

    @Override
    public List<Producto> buscarPorStockMenorQue(Integer limite) {
        return productoRepositorio.findByStockLessThan(limite);
    }

    @Override
    public List<Producto> buscarPorIdSucursal(Integer idSucursal) {
        return productoRepositorio.findByIdSucursal(idSucursal);
    }
}
