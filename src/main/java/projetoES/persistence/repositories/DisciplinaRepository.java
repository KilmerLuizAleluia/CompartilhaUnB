package projetoES.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoES.model.entities.Disciplina;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>{}
