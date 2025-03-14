package pe.edu.roberto.sistemaInventario.Productos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesItemDTO {

    private Long productId;
    private Integer quantity;
    private Double unitPrice;
    private Double subtotal;

}

