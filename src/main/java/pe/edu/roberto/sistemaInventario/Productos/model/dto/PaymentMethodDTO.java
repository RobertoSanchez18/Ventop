package pe.edu.roberto.sistemaInventario.Productos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodDTO {

    private Long id;
    private String paymentMethod;
    private String details;

}
