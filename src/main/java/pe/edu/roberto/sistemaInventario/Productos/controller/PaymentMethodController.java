package pe.edu.roberto.sistemaInventario.Productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.roberto.sistemaInventario.Productos.model.PaymentMethod;
import pe.edu.roberto.sistemaInventario.Productos.service.PaymentMethodService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paymentMethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }

    @GetMapping("/{id}")
    public PaymentMethod getPaymentMethodById(@PathVariable Long id) {
        return paymentMethodService.getPaymentMethodById(id);
    }

    @PostMapping
    public PaymentMethod savePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        return paymentMethodService.savePaymentMethod(paymentMethod);
    }

    @PutMapping("/{id}")
    public PaymentMethod updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {
        return paymentMethodService.updatePaymentMethod(id, paymentMethod);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deletePaymentMethod(id);
    }



}
