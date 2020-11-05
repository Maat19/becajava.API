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

import br.biblioteca.app.model.Nacionalidade;
import br.biblioteca.app.service.NacionalidadeService;

@RestController
@RequestMapping("/nacionalidades")
public class NacionalidadeController {

	private final NacionalidadeService _service;

	public NacionalidadeController(NacionalidadeService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Nacionalidade nacionalidade) {

		try {
			_service.criar(nacionalidade);
			return ResponseEntity.status(HttpStatus.CREATED).body("Nacionalidade inserida com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Nacionalidade> nacionalidades = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(nacionalidades);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {

		try {
			Optional<Nacionalidade> nacionalidade = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(nacionalidade);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Nacionalidade nacionalidade, @PathVariable Long id) {
		try {
			_service.atualizar(nacionalidade, id);
			return ResponseEntity.status(HttpStatus.OK).body("Nacionalidade atualizada com sucesso!");
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
