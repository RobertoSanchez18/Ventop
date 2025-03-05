package pe.edu.roberto.sistemaInventario.Productos.model;

import jakarta.persistence.*;
import lombok.*;
import pe.edu.roberto.sistemaInventario.Productos.enums.SaleStatus;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    private LocalDate date;

    private Double totalAmount;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

}
