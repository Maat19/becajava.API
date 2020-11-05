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

import br.biblioteca.app.model.Autor;
import br.biblioteca.app.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorService _service;

	public AutorController(AutorService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Autor autor) {

		try {
			_service.criar(autor);
			return ResponseEntity.status(HttpStatus.CREATED).body("Autor inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Autor> Autores = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(Autores);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {

		try {
			Optional<Autor> Autor = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(Autor);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Autor autor, @PathVariable Long id) {

		try {
			_service.atualizar(autor, id);
			return ResponseEntity.status(HttpStatus.OK).body("Autor atualizado com sucesso!");
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
