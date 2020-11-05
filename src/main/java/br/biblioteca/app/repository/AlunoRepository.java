package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.app.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
