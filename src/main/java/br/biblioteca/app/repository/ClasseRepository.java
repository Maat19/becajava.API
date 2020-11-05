package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.app.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository <Classe, Long> {

}
