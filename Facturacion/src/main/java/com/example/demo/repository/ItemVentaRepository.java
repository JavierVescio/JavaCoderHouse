package com.example.demo.repository;

import com.example.demo.models.ItemVenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemVentaRepository extends JpaRepository<ItemVenta, Long> {
    List<ItemVenta> findByVentaId(Long venta_id);
}
