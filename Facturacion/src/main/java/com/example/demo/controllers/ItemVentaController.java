package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.models.ItemVenta;
import com.example.demo.models.Producto;
import com.example.demo.models.Venta;
import com.example.demo.services.ItemVentaService;
import com.example.demo.services.ProductoService;
import com.example.demo.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemVentaController {

    @Autowired
    private ItemVentaService itemVentaService;

    @GetMapping(value="api/itemventa/{id}")
    public ItemVenta getItemVentaById(@PathVariable Long id){
        return itemVentaService.getItemVentaById(id);
    }

    @PostMapping("api/itemventa/alta")
    public String post(@RequestBody ItemVenta itemVenta){
        return itemVentaService.altaItemVenta(itemVenta);
    }

}
