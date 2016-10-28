package projetoES.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import projetoES.model.entities.PessoaExemplo;
import projetoES.persistence.repositories.PessoaRepository;

@Component
@Scope("request")
public class PessoaExemploBean {

  @Autowired
  private PessoaRepository pr;

  private PessoaExemplo pessoaExemplo = new PessoaExemplo();

  public PessoaExemplo getPessoaExemplo() {
    return pessoaExemplo;
  }

  public List<PessoaExemplo> getPessoas() {
    return pr.findAll();
  }

  public void salvar() {
    pr.save(pessoaExemplo);
    pessoaExemplo = new PessoaExemplo();
  }

}
