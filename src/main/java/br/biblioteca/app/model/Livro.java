package br.biblioteca.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long Id_livro;
	public String Titulo; 
	public int n_livros;
	
	
	@ManyToOne
	@JoinColumn (name ="Id_categoria")
	private Categoria categoria;
	
	
	@ManyToOne
	@JoinColumn (name ="Id_autor")
	private Autor autor;
	
	public Long getId_livro() {
		return Id_livro;
	}
	public void setId_livro(Long id_livro) {
		Id_livro = id_livro;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public int getN_livros() {
		return n_livros;
	}
	public void setN_livros(int n_livros) {
		this.n_livros = n_livros;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	
}
