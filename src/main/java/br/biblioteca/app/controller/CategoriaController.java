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

import br.biblioteca.app.model.Categoria;
import br.biblioteca.app.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
private final CategoriaService _service;
	
	public CategoriaController(CategoriaService service) {
		_service = service;
	}
	
	@PostMapping
    public ResponseEntity criar(@RequestBody Categoria categoria) {
		try {
		_service.criar(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body("Categoria inserido com sucesso!");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
		
    }
	
	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Categoria> categorias = _service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }
	
	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		Optional<Categoria> categoria = _service.listar(id);
	    return ResponseEntity.status(HttpStatus.OK).body(categoria);
	}
	
	@PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Categoria categoria, @PathVariable Long id) {
		_service.atualizar(categoria,id);		
        return ResponseEntity.status(HttpStatus.OK).body("Categoria atualizado com sucesso!");
    }
	
	@DeleteMapping (path = "/{id}")
 	public ResponseEntity deletar (@PathVariable Long id) {
	 _service.deletar(id);
	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
 }

}
