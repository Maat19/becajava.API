package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long Id;
	public String Nome;
	public String Telefone;
	
	@ManyToOne
	@JoinColumn (name ="Id_classe")
	private Classe Classe;

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

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public Classe getClasse() {
		return Classe;
	}

	public void setClasse(Classe classe) {
		Classe = classe;
	}

	
}
