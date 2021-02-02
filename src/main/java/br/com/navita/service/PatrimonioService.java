package br.com.navita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.navita.model.Patrimonio;
import br.com.navita.repository.PatrimonioRepository;

@Service
@Transactional
public class PatrimonioService {
	
	@Autowired
	private PatrimonioRepository patrimonioRepository;
	
	public Patrimonio save(Patrimonio patrimonio) {
		 	return patrimonioRepository.save(patrimonio);
	 }

	public List<Patrimonio> getAll() {
	    return patrimonioRepository.findAll();
	}

	public void remove(Patrimonio patrimonio) {
		patrimonioRepository.delete(patrimonio);
	}
	
	public Optional<Patrimonio> findById(Long id) {
		return patrimonioRepository.findById(id);
	}

	public Long getMaxTombo( ) {
		try {
			return patrimonioRepository.getMaxTombo();
		} catch (Exception e) {
			return (long) 1;
		}
	  
 }
	 
	
	
}