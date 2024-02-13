package com.example.demo.services;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto getProductoById(Long id){

        return productoRepository.findById(id).get();
    }

    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    public String altaProducto(Producto producto){
        productoRepository.save(producto);
        return "Guardado";
    }

    public String modificarProducto(Long id, Producto producto){
        Producto updateProducto = productoRepository.findById(id).get();
        updateProducto.setNombre(producto.getNombre());
        updateProducto.setPrecio(producto.getPrecio());
        updateProducto.setStock(producto.getStock());
        productoRepository.save(updateProducto);
        return "Modificado";
    }

    public String eliminarProducto(Long id){
        Producto deleteProducto = productoRepository.findById(id).get();
        productoRepository.delete(deleteProducto);
        return "Eliminado";
    }
}
