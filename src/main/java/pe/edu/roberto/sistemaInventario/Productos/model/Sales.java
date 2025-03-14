package pe.edu.roberto.sistemaInventario.Productos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import pe.edu.roberto.sistemaInventario.Productos.enums.SaleStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private LocalDate date;
    private Double totalAmount;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    // Agregar esta relación
    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SalesItem> items = new ArrayList<>();

    // Método para agregar un item
    public void addItem(SalesItem item) {
        items.add(item);
        item.setSales(this);
    }

    // Método para remover un item
    public void removeItem(SalesItem item) {
        items.remove(item);
        item.setSales(null);
    }

    public void calculateTotal() {
        this.totalAmount = items.stream()
                .mapToDouble(SalesItem::getSubtotal)
                .sum();
    }

}
