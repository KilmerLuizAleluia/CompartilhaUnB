package projetoES.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import projetoES.model.entities.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Integer>, JpaSpecificationExecutor {
}
