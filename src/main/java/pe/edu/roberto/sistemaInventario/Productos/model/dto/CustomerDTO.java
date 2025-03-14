package pe.edu.roberto.sistemaInventario.Productos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;
    private String nameAndSurname;
    private String email;
    private String phone;
    private String address;
    private LocalDate registrationDate;
    private String status;

}
