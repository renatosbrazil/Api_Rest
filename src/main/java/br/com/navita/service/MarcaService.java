package br.com.navita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.navita.model.Marca;
import br.com.navita.repository.MarcaRepository;

@Service
@Transactional
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public Marca save(Marca marca) {
		 	return marcaRepository.save(marca);
	 }

	public List<Marca> getAll() {
	    return marcaRepository.findAll();
	}

	public void remove(Marca marca) {
		marcaRepository.delete(marca);
	}
	
	public Optional<Marca> findById(Long id) {
		return marcaRepository.findById(id);
	}

	 
}