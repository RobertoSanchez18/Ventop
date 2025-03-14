package pe.edu.roberto.sistemaInventario.Productos.model.dto;

import lombok.*;
import pe.edu.roberto.sistemaInventario.Productos.enums.SaleStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesDTO {

    private Long customerId;
    private LocalDate date;
    private Double totalAmount;
    private Long paymentMethodId;
    private SaleStatus status;
    private List<SalesItemDTO> items = new ArrayList<>();

}
