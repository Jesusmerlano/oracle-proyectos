package com.example.inventory.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.inventory.repository.ProductoRepository;
import com.example.inventory.repository.MovimientoRepository;
import com.example.inventory.model.*;

@Service
public class InventarioService {
    private final ProductoRepository productoRepo;
    private final MovimientoRepository movRepo;
    public InventarioService(ProductoRepository p, MovimientoRepository m){ this.productoRepo = p; this.movRepo = m; }

    @Transactional
    public Movimiento registrarMovimiento(Long productoId, String tipo, Integer cantidad){
        Producto p = productoRepo.findById(productoId)
                 .orElseThrow(() -> new RuntimeException("Producto no existe"));
        if ("IN".equalsIgnoreCase(tipo)) {
            p.setStock((p.getStock() == null ? 0 : p.getStock()) + cantidad);
        } else if ("OUT".equalsIgnoreCase(tipo)) {
            if ((p.getStock()==null ? 0 : p.getStock()) < cantidad)
                throw new RuntimeException("Stock insuficiente");
            p.setStock(p.getStock() - cantidad);
        } else throw new RuntimeException("Tipo inválido");
        productoRepo.save(p);
        Movimiento mv = new Movimiento();
        mv.setProductoId(productoId); mv.setTipo(tipo); mv.setCantidad(cantidad);
        return movRepo.save(mv);
    }
}
