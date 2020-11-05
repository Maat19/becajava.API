package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.biblioteca.app.model.Aluno;
import br.biblioteca.app.model.Nacionalidade;
import br.biblioteca.app.repository.AlunoRepository;
import br.biblioteca.app.repository.NacionalidadeRepository;

@Service
public class NacionalidadeService {
	
	final NacionalidadeRepository _repository;
	
	public NacionalidadeService(NacionalidadeRepository repository) {
		_repository = repository;
	}

	public void criar(Nacionalidade nacionalidade) {

		nacionalidade.setId(new Long(0));
		_repository.save(nacionalidade);
	}
	
	public List<Nacionalidade> listar() {
		return _repository.findAll();
	}

	public Optional<Nacionalidade> listar(Long id) {
		return _repository.findById(id);
	}
	
public void atualizar(Nacionalidade nacionalidade, Long id) {
	nacionalidade.setId(id);
		_repository.save(nacionalidade);
	}

	public void deletar (Long id) {
	_repository.deleteById(id);
}
	
	
}
