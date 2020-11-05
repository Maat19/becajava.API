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
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
		
    }
	
	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Requisicao> requisicoes = _service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(requisicoes);
    }
	
	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		Optional<Requisicao> requisicao = _service.listar(id);
	    return ResponseEntity.status(HttpStatus.OK).body(requisicao);
	}
	
	@PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Requisicao requisicao, @PathVariable Long id) {
		_service.atualizar(requisicao,id);		
        return ResponseEntity.status(HttpStatus.OK).body("Requisicao atualizada com sucesso!");
    }
	
	@DeleteMapping (path = "/{id}")
 	public ResponseEntity deletar (@PathVariable Long id) {
	 _service.deletar(id);
	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
 }
}
