package pe.edu.roberto.sistemaInventario.Productos.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.roberto.sistemaInventario.Productos.enums.SaleStatus;
import pe.edu.roberto.sistemaInventario.Productos.model.dto.SalesDTO;
import pe.edu.roberto.sistemaInventario.Productos.model.*;
import pe.edu.roberto.sistemaInventario.Productos.model.dto.SalesItemDTO;
import pe.edu.roberto.sistemaInventario.Productos.repository.*;
import pe.edu.roberto.sistemaInventario.Productos.service.SalesService;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sales getSalesById(Long id) {
        return salesRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Sales saveSales(SalesDTO salesDTO) {
        //Crear la venta
        Sales sale = new Sales();

        // Buscar al cliente
        Customer customer = customerRepository.findById(salesDTO.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        sale.setCustomer(customer);

        // Asignar la fecha (si es null, asignar fecha actual)
        sale.setDate(salesDTO.getDate() != null ? salesDTO.getDate() : LocalDate.now());

        // Buscar método de pago
        if (salesDTO.getPaymentMethodId() != null) {
            PaymentMethod paymentMethod = paymentMethodRepository.findById(salesDTO.getPaymentMethodId())
                    .orElseThrow(() -> new EntityNotFoundException("Método de pago no encontrado"));
            sale.setPaymentMethod(paymentMethod);
        }

        // Asignar estado
        sale.setStatus(salesDTO.getStatus() != null ? salesDTO.getStatus() : SaleStatus.PENDIENTE);

        // Procesar items de la venta
        if (salesDTO.getItems() != null && !salesDTO.getItems().isEmpty()) {
            for (SalesItemDTO itemDTO : salesDTO.getItems()) {
                // Crear un nuevo item
                SalesItem item = new SalesItem();

                // Buscar el producto
                Product product = productRepository.findById(itemDTO.getProductId())
                        .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
                item.setProduct(product);

                // Asignar cantidad
                int quantity = itemDTO.getQuantity();
                item.setQuantity(quantity);

                // Verificar si hay suficiente stock
                if (product.getStock() < quantity) {
                    throw new IllegalStateException("Stock insuficiente para el producto: " + product.getName());
                }

                product.setStock(product.getStock() - quantity);
                productRepository.save(product);

                // Asignar precio unitario (puede venir del DTO o del producto)
                double unitPrice = itemDTO.getUnitPrice() != null ?
                        itemDTO.getUnitPrice() : product.getPrice();
                item.setUnitPrice(unitPrice);

                // Calcular subtotal
                item.setSubtotal(unitPrice * itemDTO.getQuantity());

                // Agregar item a la venta
                sale.addItem(item);
            }
        }

        // Calcular total
        sale.calculateTotal();

        // Guardar en la base de datos
        return salesRepository.save(sale);
    }

    @Override
    public Sales updateSales(Long id, Sales sale) {
        Sales saleUpdated = getSalesById(id);

        saleUpdated.setCustomer(sale.getCustomer());
        saleUpdated.setDate(sale.getDate());
        saleUpdated.setTotalAmount(sale.getTotalAmount());
        saleUpdated.setPaymentMethod(sale.getPaymentMethod());
        saleUpdated.setStatus(sale.getStatus());

        return salesRepository.save(saleUpdated);
    }

    @Override
    public void deleteSales(Long id) {
        salesRepository.deleteById(id);
    }

    @Override
    public List<Sales> getSalesByCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return salesRepository.findByCustomerId(customer.getId());
    }

}
