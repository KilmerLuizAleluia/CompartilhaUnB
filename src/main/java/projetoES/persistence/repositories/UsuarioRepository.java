package projetoES.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoES.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
}
