package projetoES.model.entities;

import javax.persistence.*;

@Entity
@Table
public class Resposta {

    private static final String SEQUENCE = "SQ_RESPOSTA";

    @Id
    @GeneratedValue(generator = SEQUENCE, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = SEQUENCE, sequenceName = SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 10000)
    private String descricao;

    private Integer numeroLikes = 0;
    private Integer numeroDeslikes = 0;

    @ManyToOne
    private Pergunta pergunta;

    @ManyToOne
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
