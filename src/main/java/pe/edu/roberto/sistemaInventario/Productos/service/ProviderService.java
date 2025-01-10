package pe.edu.roberto.sistemaInventario.Productos.service;

import java.util.List;
import pe.edu.roberto.sistemaInventario.Productos.model.Provider;


public interface ProviderService {
	
	 	List<Provider> getAllProviders();

	 	Provider getProviderById(Long id);

	 	Provider saveProvider(Provider provider);

	 	Provider updateProvider(Long id, Provider providerDetails);

	    void deleteProvider(Long id);
	
}
