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

import br.biblioteca.app.model.Classe;
import br.biblioteca.app.service.ClasseService;

@RestController
@RequestMapping("/classes")
public class ClasseController {

	private final ClasseService _service;

	public ClasseController(ClasseService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Classe classe) {

		try {
			_service.criar(classe);
			return ResponseEntity.status(HttpStatus.CREATED).body("Classe inserida com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Classe> classes = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(classes);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {

		try {
			Optional<Classe> classe = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(classe);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Classe Classe, @PathVariable Long id) {
		try {
			_service.atualizar(Classe, id);
			return ResponseEntity.status(HttpStatus.OK).body("Classe atualizada com sucesso!");
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
