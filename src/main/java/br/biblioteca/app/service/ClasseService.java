package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.biblioteca.app.model.Classe;
import br.biblioteca.app.model.Nacionalidade;
import br.biblioteca.app.repository.ClasseRepository;
import br.biblioteca.app.repository.NacionalidadeRepository;
@Service
public class ClasseService {

	
final ClasseRepository _repository;
	
	public ClasseService(ClasseRepository repository) {
		_repository = repository;
	}

	public void criar(Classe classe) {

		classe.setId(new Long(0));
		_repository.save(classe);
	}
	
	public List<Classe> listar() {
		return _repository.findAll();
	}

	public Optional<Classe> listar(Long id) {
		return _repository.findById(id);
	}
	
	public void atualizar(Classe classe, Long id) {
	classe.setId(id);
		_repository.save(classe);
	}

	public void deletar (Long id) {
	_repository.deleteById(id);
}
	
}
