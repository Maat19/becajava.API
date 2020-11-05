package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long Id_categoria;
	public String nome;
	
	
	public Long getId_categoria() {
		return Id_categoria;
	}
	public void setId_categoria(Long id_categoria) {
		Id_categoria = id_categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}



