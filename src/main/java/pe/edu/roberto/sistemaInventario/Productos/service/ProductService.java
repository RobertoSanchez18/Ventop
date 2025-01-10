package pe.edu.roberto.sistemaInventario.Productos.service;

import pe.edu.roberto.sistemaInventario.Productos.model.Product;
import pe.edu.roberto.sistemaInventario.Productos.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product saveProduct(ProductDTO productDTO);

    Product updateProduct(Long id, Product productDetails);

    void deleteProduct(Long id);
}
