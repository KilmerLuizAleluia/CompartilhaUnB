package projetoES.model.entities;

import projetoES.model.enums.TipoDocumento;

import javax.persistence.*;

@Entity
@Table
public class Documento {

    private static final String SEQUENCE = "SQ_DOCUMENTO";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(sequenceName = SEQUENCE, name = SEQUENCE, allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(nullable = false, length = 511)
    private String caminho;

    @Column(length = 1023)
    private String descricao;

    @Enumerated
    private TipoDocumento tipoDocumento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Disciplina disciplina;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
