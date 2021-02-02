package br.com.navita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.navita.model.Cliente;
import br.com.navita.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	// A camada de serviço utilizada para comunicação com o repositorio e a interface 
	//(Controller) e utilizada para a implementação das regras de negocios.
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> getAll() {
	    return clienteRepository.findAll();
	}

	public void remove(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	public Optional<Cliente> getId(Long id) {
		return clienteRepository.findById(id);
	}	
 
}