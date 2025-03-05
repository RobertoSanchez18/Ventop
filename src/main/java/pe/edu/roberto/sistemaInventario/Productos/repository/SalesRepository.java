package pe.edu.roberto.sistemaInventario.Productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.roberto.sistemaInventario.Productos.model.Customer;
import pe.edu.roberto.sistemaInventario.Productos.model.Sales;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findByCustomer(Customer customer);

}
