package pe.edu.roberto.sistemaInventario.Productos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.roberto.sistemaInventario.Productos.model.Category;
import pe.edu.roberto.sistemaInventario.Productos.model.Product;
import pe.edu.roberto.sistemaInventario.Productos.model.dto.ProductDTO;
import pe.edu.roberto.sistemaInventario.Productos.repository.CategoryRepository;
import pe.edu.roberto.sistemaInventario.Productos.repository.ProductRepository;
import pe.edu.roberto.sistemaInventario.Productos.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        // Buscar la categoría por su ID
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoria con el id: " + productDTO.getCategoryId()));

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setStock(productDetails.getStock());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
