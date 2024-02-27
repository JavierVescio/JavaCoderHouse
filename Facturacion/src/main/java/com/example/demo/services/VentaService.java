package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.models.ItemVenta;
import com.example.demo.models.Producto;
import com.example.demo.models.Venta;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ItemVentaRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.VentaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ItemVentaRepository itemVentaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Venta getVentaById(Long id){
        Venta venta = ventaRepository.findById(id).get();
        List<ItemVenta> itemVentaList = itemVentaRepository.findByVentaId(id);
        float total = 0;
        for (ItemVenta itemVenta: itemVentaList) {
            total = total + itemVenta.getSubtotal();
        }
        venta.setPrecioTotal(total);
        return venta;
    }

    public List<Venta> getVentas(){
        return ventaRepository.findAll();
    }

    public String altaVenta(Venta venta){
        Optional<Cliente> optionalCliente = clienteRepository.findById(venta.getCliente().getId());
        if (optionalCliente.isEmpty()) {
            return "El cliente no existe";
        }
        ventaRepository.save(venta);
        return "Guardado";
    }

    public String confirmar(Long id) throws Exception{
        Venta venta = ventaRepository.findById(id).get();
        List<ItemVenta> itemVentaList = itemVentaRepository.findByVentaId(id);
        if (!venta.isConfirmada() & itemVentaList.size() > 0) {
            float total = 0;
            for (ItemVenta itemVenta: itemVentaList) {
                total = total + itemVenta.getSubtotal();

                Producto producto = itemVenta.getProducto();
                if (producto.getStock() < itemVenta.getCantidad()) {
                    throw new Exception("Sólo hay " + String.valueOf(producto.getStock()) + " unidades de " + producto.getNombre() + ".");
                }
                producto.setStock(producto.getStock() - itemVenta.getCantidad());
            }
            venta.setPrecioTotal(total);
            venta.setConfirmada(true);
            venta.setFecha(FechaRestApi.getFecha());
            ventaRepository.save(venta);
            String encabezado = "Venta realizada. Stock actual: \n";
            String nombreProductoStock = "";
            for (Producto producto : productoRepository.findAll()) {
                nombreProductoStock = nombreProductoStock + "\n" + producto.getNombre() + " " + String.valueOf(producto.getStock()) + "u.";
            }
            return encabezado + nombreProductoStock;
        }
        return "Venta ya confirmada o sin items";
    }

}
