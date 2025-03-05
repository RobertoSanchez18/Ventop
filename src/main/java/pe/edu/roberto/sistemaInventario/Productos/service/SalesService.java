package pe.edu.roberto.sistemaInventario.Productos.service;

import org.springframework.stereotype.Service;
import pe.edu.roberto.sistemaInventario.Productos.dto.SalesDTO;
import pe.edu.roberto.sistemaInventario.Productos.model.Provider;
import pe.edu.roberto.sistemaInventario.Productos.model.Sales;

import java.util.List;


public interface SalesService {

    List<Sales> getAllSales();

    Sales getSalesById(Long id);

    Sales saveSales(SalesDTO salesDTO);

    Sales updateSales(Long id, Sales sale);

    void deleteSales(Long id);

    List<Sales> getSalesByCustomer(Long customerId);

}
