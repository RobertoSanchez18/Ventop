package pe.edu.roberto.sistemaInventario.Productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.roberto.sistemaInventario.Productos.model.Provider;
import pe.edu.roberto.sistemaInventario.Productos.repository.ProviderRepository;
import pe.edu.roberto.sistemaInventario.Productos.service.impl.ProviderServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/providers")
public class ProviderController {

	@Autowired
	private ProviderServiceImpl providerService;
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@GetMapping
	public Page<Provider> getAllProviders(@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "6") int size){
		Pageable pageable = PageRequest.of(page, size);
		return providerRepository.findByNameContainingIgnoreCase(name, pageable);
	}
	
	@GetMapping("/{id}")
	public Provider getProviderById(@PathVariable Long id) {
		return providerService.getProviderById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> createProvider(@RequestBody Provider provider) {
		Provider providerRequest = providerService.saveProvider(provider);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(providerRequest);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProvider(@PathVariable Long id, @RequestBody Provider providerDetails) {
		Provider provider =  providerService.updateProvider(id, providerDetails);
		return ResponseEntity.status(HttpStatus.OK)
				.body(provider);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return ResponseEntity.ok().build();
    }
	
}
