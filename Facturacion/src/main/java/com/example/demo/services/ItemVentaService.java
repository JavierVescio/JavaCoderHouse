package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.models.ItemVenta;
import com.example.demo.models.Producto;
import com.example.demo.models.Venta;
import com.example.demo.repository.ItemVentaRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemVentaService {
    @Autowired
    private ItemVentaRepository itemVentaRepository;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepository;

    public ItemVenta getItemVentaById(Long id){
        ItemVenta itemVenta = itemVentaRepository.findById(id).get();
        return itemVenta;
    }

    public String altaItemVenta(ItemVenta itemVenta){
        Optional<Venta> optionalVenta = ventaRepository.findById(itemVenta.getVenta().getId());
        if (optionalVenta.isEmpty()) {
            return "La venta no existe";
        }
        Venta venta = optionalVenta.get();
        if (venta.isConfirmada()) {
            return "No puede agregar items a una venta que ya se encuentra cerrada/confirmada";
        }
        Optional<Producto> optionalProducto = productoRepository.findById(itemVenta.getProducto().getId());
        if (optionalProducto.isEmpty()) {
            return "El producto no existe";
        }
        Producto producto = optionalProducto.get();
        if (producto.getStock() < itemVenta.getCantidad()) {
            return "Sólo hay " + String.valueOf(producto.getStock()) + " unidades de " + producto.getNombre() + ".";
        }
        itemVenta.setPrecio(producto.getPrecio());
        itemVenta.setSubtotal(producto.getPrecio() * itemVenta.getCantidad());
        ItemVenta itemVenta1 = itemVentaRepository.save(itemVenta);
        return "Guardado";
    }

}
