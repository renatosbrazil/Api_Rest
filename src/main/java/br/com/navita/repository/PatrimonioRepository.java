package br.com.navita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.navita.model.Patrimonio;
@Repository

public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {
	
 
	@Query(value = "SELECT  MAX(tombo)+1 FROM patrimonio;", nativeQuery = true)
	Long getMaxTombo();

	 
	
}
