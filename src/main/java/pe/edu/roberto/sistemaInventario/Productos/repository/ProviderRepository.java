package pe.edu.roberto.sistemaInventario.Productos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import pe.edu.roberto.sistemaInventario.Productos.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>, PagingAndSortingRepository<Provider, Long> {
	 Page<Provider> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
