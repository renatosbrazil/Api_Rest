package br.com.navita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.navita.model.Marca;

@Repository
public interface  MarcaRepository  extends JpaRepository<Marca, Long>  {

	
	
	
}
