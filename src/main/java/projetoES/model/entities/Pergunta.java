package projetoES.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Pergunta {

    private static final String SEQUENCE = "SQ_PERGUNTA";

    @Id
    @GeneratedValue(generator = SEQUENCE, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = SEQUENCE, name = SEQUENCE, initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 10000)
    private String descricao;


    private Integer numeroLikes;
    private Integer numeroDeslikes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Disciplina disciplina;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(Integer numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public synchronized void incrementarNumeroLikes() {
        this.numeroLikes++;
    }

    public Integer getNumeroDeslikes() {
        return numeroDeslikes;
    }

    public void setNumeroDeslikes(Integer numeroDeslikes) {
        this.numeroDeslikes = numeroDeslikes;
    }

    public synchronized void incrementarNumeroDeslikes() {
        this.numeroDeslikes++;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
