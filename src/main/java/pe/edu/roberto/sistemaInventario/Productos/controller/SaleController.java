package pe.edu.roberto.sistemaInventario.Productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.roberto.sistemaInventario.Productos.model.dto.SalesDTO;
import pe.edu.roberto.sistemaInventario.Productos.model.Sales;
import pe.edu.roberto.sistemaInventario.Productos.service.SalesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sales getSaleById(@PathVariable Long id) {
        return salesService.getSalesById(id);
    }

    @PostMapping
    public ResponseEntity<Sales> createSale(@RequestBody SalesDTO salesDTO) {
        Sales createdSale = salesService.saveSales(salesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSale);
    }

    @PutMapping("/{id}")
    public Sales updateSale(@PathVariable Long id, @RequestBody Sales sale) {
        return salesService.updateSales(id, sale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Long id) {
        salesService.deleteSales(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Sales> getSalesByCustomer(@PathVariable Long customerId) {
        return salesService.getSalesByCustomer(customerId);
    }

}
