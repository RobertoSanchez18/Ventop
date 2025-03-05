package pe.edu.roberto.sistemaInventario.Productos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import pe.edu.roberto.sistemaInventario.Productos.model.Customer;
import pe.edu.roberto.sistemaInventario.Productos.repository.CustomerRepository;
import pe.edu.roberto.sistemaInventario.Productos.service.CustomerService;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return  customerRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        // Obtiene la fecha actual
        LocalDate dateToday = LocalDate.now();
        // Inserta la fecha actual a registrationDate
        customer.setRegistrationDate(dateToday);
        // El estado por defecto en A = Activo
        customer.setStatus("A");
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerUpdate = getCustomerById(id);

        customerUpdate.setNameAndSurname(customer.getNameAndSurname());
        customerUpdate.setPhone(customer.getPhone());
        customerUpdate.setEmail(customer.getEmail());
        customerUpdate.setAddress(customer.getAddress());
        customerUpdate.setStatus(customer.getStatus());

        return customerRepository.save(customerUpdate);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
