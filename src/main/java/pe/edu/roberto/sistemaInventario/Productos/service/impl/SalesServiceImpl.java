package pe.edu.roberto.sistemaInventario.Productos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.roberto.sistemaInventario.Productos.dto.SalesDTO;
import pe.edu.roberto.sistemaInventario.Productos.model.Customer;
import pe.edu.roberto.sistemaInventario.Productos.model.PaymentMethod;
import pe.edu.roberto.sistemaInventario.Productos.model.Sales;
import pe.edu.roberto.sistemaInventario.Productos.repository.CustomerRepository;
import pe.edu.roberto.sistemaInventario.Productos.repository.PaymentMethodRepository;
import pe.edu.roberto.sistemaInventario.Productos.repository.SalesRepository;
import pe.edu.roberto.sistemaInventario.Productos.service.SalesService;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


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
        Customer customer = customerRepository.findById(salesDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        PaymentMethod paymentMethod = paymentMethodRepository.findById(salesDTO.getPaymentMethodId())
                .orElseThrow(() -> new RuntimeException("Payment Method not found"));


        Sales sale = new Sales();
        sale.setCustomer(customer);
        sale.setDate(salesDTO.getDate());
        sale.setTotalAmount(salesDTO.getTotalAmount());
        sale.setPaymentMethod(paymentMethod);
        sale.setStatus(salesDTO.getStatus());

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

        return salesRepository.findByCustomer(customer);
    }

}
