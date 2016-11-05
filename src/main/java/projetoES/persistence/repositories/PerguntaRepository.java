package projetoES.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import projetoES.model.entities.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Integer>, JpaSpecificationExecutor {}
