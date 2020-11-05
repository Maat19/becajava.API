package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long Id_autor; 
    public String Nome;
    
    
	public Long getId_autor() {
		return Id_autor;
	}
	public void setId_autor(Long id_autor) {
		Id_autor = id_autor;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
      
}
