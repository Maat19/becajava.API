package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Requisicao {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long id_requisicao;
	
	@ManyToOne
	@JoinColumn (name ="id_aluno")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn (name ="id_livro")
	private Livro livro;

	public Long getId_requisicao() {
		return id_requisicao;
	}

	public void setId_requisicao(Long id_requisicao) {
		this.id_requisicao = id_requisicao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
}
