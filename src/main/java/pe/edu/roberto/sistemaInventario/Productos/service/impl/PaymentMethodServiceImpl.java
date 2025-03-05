package pe.edu.roberto.sistemaInventario.Productos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.roberto.sistemaInventario.Productos.model.PaymentMethod;
import pe.edu.roberto.sistemaInventario.Productos.repository.PaymentMethodRepository;
import pe.edu.roberto.sistemaInventario.Productos.service.PaymentMethodService;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Method not found"));
    }

    @Override
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod paymentMethodDetails) {
        PaymentMethod paymentMethod = getPaymentMethodById(id);

        paymentMethod.setPaymentMethod(paymentMethodDetails.getPaymentMethod());
        paymentMethod.setDetails(paymentMethodDetails.getDetails());

        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id);
    }
}
