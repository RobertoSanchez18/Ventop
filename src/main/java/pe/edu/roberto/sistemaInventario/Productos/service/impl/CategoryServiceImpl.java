package pe.edu.roberto.sistemaInventario.Productos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.roberto.sistemaInventario.Productos.model.Category;
import pe.edu.roberto.sistemaInventario.Productos.model.Product;
import pe.edu.roberto.sistemaInventario.Productos.repository.CategoryRepository;
import pe.edu.roberto.sistemaInventario.Productos.service.CategoryService;
import pe.edu.roberto.sistemaInventario.Productos.service.ProductService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + id));
    }

    @Override
    public Category createCategory(Category category) {
        if(categoryRepository.existsByName(category.getName())) {
            throw new RuntimeException("Ya existe una categoria con el nombre: " + category.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existing = getCategoryById(id);
        existing.setName(category.getName());
        existing.setDescription(category.getDescription());

        return categoryRepository.save(existing);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
