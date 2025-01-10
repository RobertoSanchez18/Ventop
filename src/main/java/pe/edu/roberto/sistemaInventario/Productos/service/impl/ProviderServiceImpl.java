package pe.edu.roberto.sistemaInventario.Productos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.roberto.sistemaInventario.Productos.model.Provider;
import pe.edu.roberto.sistemaInventario.Productos.repository.ProviderRepository;
import pe.edu.roberto.sistemaInventario.Productos.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService{
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@Override
	public List<Provider> getAllProviders() {
		return providerRepository.findAll();
	}

	@Override
	public Provider getProviderById(Long id) {
		return providerRepository.findById(id)
				.orElseThrow();
	}

	@Override
	public Provider saveProvider(Provider provider) {
		return providerRepository.save(provider);
	}

	@Override
	public Provider updateProvider(Long id, Provider providerDetails) {
		Provider provider = getProviderById(id);
		
		provider.setName(providerDetails.getName());
		provider.setEmail(providerDetails.getEmail());
		provider.setAddress(providerDetails.getAddress());
		provider.setPhone(providerDetails.getPhone());
		
		return providerRepository.save(provider);
	}

	@Override
	public void deleteProvider(Long id) {
		providerRepository.deleteById(id);
		
	}

}
