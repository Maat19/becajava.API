package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.app.model.Nacionalidade;

@Repository
public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Long> {

}
