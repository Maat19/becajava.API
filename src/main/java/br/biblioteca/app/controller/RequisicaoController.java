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

import br.biblioteca.app.model.Requisicao;
import br.biblioteca.app.service.RequisicaoService;

@RestController
@RequestMapping("/requisicoes")
public class RequisicaoController {

	private final RequisicaoService _service;

	public RequisicaoController(RequisicaoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Requisicao requisicao) {
		try {
			_service.criar(requisicao);
			return ResponseEntity.status(HttpStatus.CREATED).body("Requisicao inserida com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}

	}

	@GetMapping
	public ResponseEntity listar() {

		try {
			Iterable<Requisicao> requisicoes = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(requisicoes);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		try {
			Optional<Requisicao> requisicao = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(requisicao);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Requisicao requisicao, @PathVariable Long id) {

		try {
			_service.atualizar(requisicao, id);
			return ResponseEntity.status(HttpStatus.OK).body("Requisicao atualizada com sucesso!");
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
