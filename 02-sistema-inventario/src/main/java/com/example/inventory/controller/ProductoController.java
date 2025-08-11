package com.example.inventory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.inventory.model.Producto;
import com.example.inventory.model.Movimiento;
import com.example.inventory.repository.ProductoRepository;
import com.example.inventory.service.InventarioService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoRepository productoRepo;
    private final InventarioService inventarioService;

    public ProductoController(ProductoRepository productoRepo, InventarioService inventarioService){
        this.productoRepo = productoRepo;
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Producto> list(){ return productoRepo.findAll(); }

    @PostMapping
    public Producto create(@RequestBody Producto p){ return productoRepo.save(p); }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable Long id){
        return productoRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/movimientos")
    public ResponseEntity<?> movimiento(@PathVariable Long id, @RequestBody Movimiento m){
        try {
            Movimiento mv = inventarioService.registrarMovimiento(id, m.getTipo(), m.getCantidad());
            return ResponseEntity.ok(mv);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
