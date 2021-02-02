package br.com.navita.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class Patrimonio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patrimonioId;
	
	private String nome;
	
	private String descricao;
	
	private Long tombo;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;

	public Long getPatrimonioId() {
		return patrimonioId;
	}

	public void setPatrimonioId(Long patrimonioId) {
		this.patrimonioId = patrimonioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTombo() {
		return tombo;
	}

	public void setTombo(Long tombo) {
		this.tombo = tombo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
public Patrimonio() {
	// TODO Auto-generated constructor stub
}

public Patrimonio(Long patrimonioId, String nome, String descricao, @UniqueElements Long tombo, Marca marca) {
	super();
	this.patrimonioId = patrimonioId;
	this.nome = nome;
	this.descricao = descricao;
	this.tombo = tombo;
	this.marca = marca;
}

@Override
public String toString() {
	return "Patrimonio [patrimonioId=" + patrimonioId + ", nome=" + nome + ", descricao=" + descricao + ", tombo="
			+ tombo + ", marca=" + marca + "]";
}
	
	 
	 
	
}