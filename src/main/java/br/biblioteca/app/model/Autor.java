package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	public String Nome;

	@ManyToOne
	@JoinColumn(name = "Id_nacionalidade")
	private Nacionalidade Nacionalidade;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Nacionalidade getNacionalidade() {
		return Nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		Nacionalidade = nacionalidade;
	}

	
}
