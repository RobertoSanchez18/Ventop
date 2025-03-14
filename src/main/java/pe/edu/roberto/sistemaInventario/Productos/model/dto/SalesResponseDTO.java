package pe.edu.roberto.sistemaInventario.Productos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.roberto.sistemaInventario.Productos.enums.SaleStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesResponseDTO {

    private Long id;
    private CustomerDTO customer;
    private LocalDate date;
    private Double totalAmount;
    private PaymentMethodDTO paymentMethod;
    private SaleStatus status;
    private List<SalesItemResponseDTO> items = new ArrayList<>();


}
