package projetoES.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PessoaExemplo {

  private static final String SEQUENCE = "pessoa_sequence";

  private Long id;
  private String nome;

  @Id
  @GeneratedValue(generator = SEQUENCE, strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
