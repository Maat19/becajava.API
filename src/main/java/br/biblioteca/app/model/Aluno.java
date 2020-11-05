package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long id_aluno;
	public String Nome_aluno;
	public String telefone;
	
	public Long getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Long id_aluno) {
		this.id_aluno = id_aluno;
	}
	public String getNome_aluno() {
		return Nome_aluno;
	}
	public void setNome_aluno(String nome_aluno) {
		Nome_aluno = nome_aluno;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	
}
