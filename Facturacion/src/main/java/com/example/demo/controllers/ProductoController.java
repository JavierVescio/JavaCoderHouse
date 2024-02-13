package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.models.Producto;
import com.example.demo.services.ClienteService;
import com.example.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value="api/producto/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoService.getProductoById(id);
    }

    @GetMapping("api/producto")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }

    @PostMapping("api/producto/alta")
    public String post(@RequestBody Producto producto){
        return productoService.altaProducto(producto);
    }

    @PutMapping("api/producto/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Producto producto){
        return productoService.modificarProducto(id, producto);
    }

    @DeleteMapping("api/producto/baja/{id}")
    public String delete(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return "Eliminado";
    }



}
