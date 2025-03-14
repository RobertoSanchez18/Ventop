package pe.edu.roberto.sistemaInventario.Productos.repository;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.roberto.sistemaInventario.Productos.enums.SaleStatus;
import pe.edu.roberto.sistemaInventario.Productos.model.Customer;
import pe.edu.roberto.sistemaInventario.Productos.model.Sales;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findByCustomerId(Long customerId);
    List<Sales> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Sales> findByStatus(SaleStatus status);

    List<Sales> findByCustomer(Customer customer, Sort sort, Limit limit);
}
