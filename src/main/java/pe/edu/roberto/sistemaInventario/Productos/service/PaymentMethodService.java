package pe.edu.roberto.sistemaInventario.Productos.service;

import pe.edu.roberto.sistemaInventario.Productos.model.PaymentMethod;
import pe.edu.roberto.sistemaInventario.Productos.model.Product;
import pe.edu.roberto.sistemaInventario.Productos.model.dto.ProductDTO;

import java.util.List;

public interface PaymentMethodService {

    List<PaymentMethod> getAllPaymentMethods();

    PaymentMethod getPaymentMethodById(Long id);

    PaymentMethod savePaymentMethod(PaymentMethod paymentMethod);

    PaymentMethod updatePaymentMethod(Long id, PaymentMethod paymentMethodDetails);

    void deletePaymentMethod(Long id);

}
