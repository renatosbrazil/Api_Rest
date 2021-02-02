package br.com.navita.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import br.com.navita.model.Marca;
import br.com.navita.service.MarcaService;

@RestController
@RequestMapping("api")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping(value="/marcas")
	public ResponseEntity<List<Marca>> getAll(){
		List<Marca> marca = marcaService.getAll();
		return new ResponseEntity<>(marca,HttpStatus.OK);
	}	
	
	@GetMapping(value = "/marca/{id}")
	public ResponseEntity<Marca> getObject(@PathVariable("id") Long id) {
		Optional<Marca> marca =  marcaService.findById(id);
		if (!marca.isPresent()) {			
			return new ResponseEntity<Marca>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Marca>(marca.get(), HttpStatus.OK);
	}
	
	@PostMapping(value="/marca")
	public ResponseEntity<Marca> create(@Valid @RequestBody Marca marca) throws Exception{	
		try {
		marcaService.save(marca);		
		return new ResponseEntity<Marca>(HttpStatus.CREATED);
	}	catch (Exception e) {
		throw new Exception ("Nome já existe");	
		}
	}
	
	@PutMapping(value="/marca")
	public ResponseEntity<Marca> update(@RequestBody Marca marca){
		Marca marcaNova = marcaService.save(marca);		
		return new ResponseEntity<Marca>(marcaNova, HttpStatus.ACCEPTED);
	}	

	@DeleteMapping(value="/marca/{id}")
	public ResponseEntity<Marca> delete(@PathVariable Long id){
		Optional<Marca> marca = marcaService.findById(id);
		if(!marca.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		marcaService.remove(marca.get());
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}