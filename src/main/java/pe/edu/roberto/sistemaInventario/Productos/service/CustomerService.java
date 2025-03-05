package pe.edu.roberto.sistemaInventario.Productos.service;

import pe.edu.roberto.sistemaInventario.Productos.model.Category;
import pe.edu.roberto.sistemaInventario.Productos.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);

}
