package br.com.navita.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.navita.model.Patrimonio;
import br.com.navita.service.PatrimonioService;

@RestController
@RequestMapping("api")
public class PatrimonioController {
	
	@Autowired
	private PatrimonioService patrimonioService;
	
	@GetMapping(value="/patrimonios")
	public ResponseEntity<List<Patrimonio>> getAll(){
		List<Patrimonio> patrimonio = patrimonioService.getAll();
		return new ResponseEntity<>(patrimonio,HttpStatus.OK);
	}	
	
	@GetMapping(value = "/patrimonio/{id}")
	public ResponseEntity<Patrimonio> getObject(@PathVariable("id") Long id) {
		Optional<Patrimonio> patrimonio =  patrimonioService.findById(id);
		if (!patrimonio.isPresent()) {			
			return new ResponseEntity<Patrimonio>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Patrimonio>(patrimonio.get(), HttpStatus.OK);
	}
	
	@PostMapping(value="/patrimonio")
	public ResponseEntity<Patrimonio> create(@RequestBody Patrimonio patrimonio){	
		patrimonio.setTombo(patrimonioService.getMaxTombo());
		patrimonioService.save(patrimonio);		
		return new ResponseEntity<Patrimonio>(HttpStatus.CREATED);
	}	
	
	@PutMapping(value="/patrimonio")
	public ResponseEntity<Patrimonio> update(@RequestBody Patrimonio patrimonio){
				Patrimonio patrimonioNovo = patrimonioService.save(patrimonio);		
		return new ResponseEntity<Patrimonio>(patrimonioNovo, HttpStatus.ACCEPTED);
	}	

	@DeleteMapping(value="/patrimonio/{id}")
	public ResponseEntity<Patrimonio> delete(@PathVariable Long id){
		Optional<Patrimonio> patrimonio = patrimonioService.findById(id);
		if(!patrimonio.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		patrimonioService.remove(patrimonio.get());
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}