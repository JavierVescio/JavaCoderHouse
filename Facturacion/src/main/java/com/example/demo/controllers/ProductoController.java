package com.example.demo.controllers;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository repo;

    @GetMapping("api/productos")
    public List<Producto> getProductos(){
        return  repo.findAll();
    }

    @PostMapping("api/producto")
    public String post(@RequestBody Producto producto){
        repo.save(producto);
        return "Guardado";
    }

    @PutMapping("api/producto/{id}")
    public String update(@PathVariable Long id, @RequestBody Producto producto){
        Producto updateProducto = repo.findById(id).get();
        updateProducto.setNombre(producto.getNombre());
        updateProducto.setPrecio(producto.getPrecio());
        updateProducto.setStock(producto.getStock());
        repo.save(updateProducto);
        return "Modificado";
    }

    @DeleteMapping("api/producto/{id}")
        public String delete(@PathVariable Long id){

        Producto deleteProducto = repo.findById(id).get();
        repo.delete(deleteProducto);
        return "Eliminado";
    }



}
