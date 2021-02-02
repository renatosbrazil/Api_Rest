package br.com.navita.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marca", fetch = FetchType.EAGER)
	private List<Patrimonio> patrimonio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Patrimonio> getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(List<Patrimonio> patrimonio) {
		this.patrimonio = patrimonio;
	}

	public Marca(Long id, String nome, List<Patrimonio> patrimonio) {
		super();
		this.id = id;
		this.nome = nome;
		this.patrimonio = patrimonio;
	}

	 public Marca() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nome=" + nome + ", patrimonio=" + patrimonio + "]";
	}

	
	
	
}
