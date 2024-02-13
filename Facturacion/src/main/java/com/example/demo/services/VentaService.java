package com.example.demo.services;

import com.example.demo.models.ItemVenta;
import com.example.demo.models.Venta;
import com.example.demo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public Venta getVentaById(Long id){
        return ventaRepository.findById(id).get();
    }

    public List<ItemVenta> getItemsByVentaId(Long id){
        Venta venta = ventaRepository.findById(id).get();
        return venta.getItems();
    }

    public List<Venta> getVentas(){
        return ventaRepository.findAll();
    }

    public String altaVenta(Venta venta){
        ventaRepository.save(venta);
        return "Guardado";
    }

    public String confirmar(Long id){
        Venta venta = ventaRepository.findById(id).get();
        if (!venta.isConfirmada() & venta.getItems().size() > 0) {
            venta.setConfirmada(true);
            venta.setFecha(LocalDateTime.now());
            ventaRepository.save(venta);
            return "Modificado";
        }
        return "Venta ya confirmada o sin items";
    }

    public String agregarItemVenta(ItemVenta itemVenta){
        Venta venta = itemVenta.getVenta();
        if (venta != null && !venta.isConfirmada()) {
            float precioProducto = itemVenta.getProducto().getPrecio();
            int unidadesCompradas = itemVenta.getCantidad();
            float subtotal = precioProducto * unidadesCompradas;

            itemVenta.setSubtotal(subtotal);
            venta.setPrecioTotal(subtotal);

            venta.addItemVenta(itemVenta);

            ventaRepository.save(venta);
            return "Guardado";
        }
        return "Venta ya confirmada o inexistente";
    }

}
