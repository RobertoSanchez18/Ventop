package pe.edu.roberto.sistemaInventario.Productos.dto;

import lombok.Data;
import pe.edu.roberto.sistemaInventario.Productos.enums.SaleStatus;

import java.time.LocalDate;

@Data
public class SalesDTO {

    private Long customerId;
    private LocalDate date;
    private Double totalAmount;
    private Long paymentMethodId;
    private SaleStatus status;

}
