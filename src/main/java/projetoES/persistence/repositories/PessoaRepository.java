package projetoES.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoES.model.entities.PessoaExemplo;

public interface PessoaRepository extends JpaRepository<PessoaExemplo, Long> {}
