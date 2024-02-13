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

    @PostMapping("api/venta/item")
    public String agregarItem(@RequestBody ItemVenta itemVenta){
        return ventaService.agregarItemVenta(itemVenta);
    }

    @GetMapping("api/venta/item/{id}")
    public List<ItemVenta> getVentas(Long id){
        return ventaService.getItemsByVentaId(id);
    }


    @PutMapping("api/venta/confirmar/{id}")
    public String confirmarVenta(@PathVariable Long id){
        return ventaService.confirmar(id);
    }

}
