package com.example.demo.controllers;

import com.example.demo.models.ItemVenta;
import com.example.demo.models.Producto;
import com.example.demo.models.Venta;
import com.example.demo.services.ProductoService;
import com.example.demo.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping(value="api/venta/{id}")
    public Venta getVentaById(@PathVariable Long id){
        return ventaService.getVentaById(id);
    }

    @GetMapping("api/venta")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    @PostMapping("api/venta/alta")
    public String post(@RequestBody Venta venta){
        return ventaService.altaVenta(venta);
    }

    @PutMapping("api/venta/confirmar/{id}")
    public String confirmarVenta(@PathVariable Long id){
        try {
            return ventaService.confirmar(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
