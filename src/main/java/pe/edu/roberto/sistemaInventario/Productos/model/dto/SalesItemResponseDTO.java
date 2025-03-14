package pe.edu.roberto.sistemaInventario.Productos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesItemResponseDTO {

    private Long id;
    private ProductDTO product;
    private Integer quantity;
    private Double unitPrice;
    private Double subtotal;

}
