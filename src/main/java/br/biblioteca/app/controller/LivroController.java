package br.biblioteca.app.controller;

import java.util.Optional;

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

import br.biblioteca.app.model.Livro;
import br.biblioteca.app.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	private final LivroService _service;

	public LivroController(LivroService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Livro livro) {

		try {
			_service.criar(livro);
			return ResponseEntity.status(HttpStatus.CREATED).body("Livro inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

//colcar try em todos
	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Livro> livros = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(livros);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		try {
			Optional<Livro> livro = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(livro);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Livro livro, @PathVariable Long id) {
		try {
			_service.atualizar(livro, id);
			return ResponseEntity.status(HttpStatus.OK).body("Livro atualizado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		try {
			_service.deletar(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

}
