package projetoES.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import projetoES.model.entities.Disciplina;
import projetoES.model.entities.Pergunta;
import projetoES.model.entities.Resposta;
import projetoES.persistence.repositories.DisciplinaRepository;
import projetoES.persistence.repositories.PerguntaRepository;
import projetoES.persistence.repositories.RespostaRepository;
import projetoES.persistence.specifications.PerguntaSpecification;
import projetoES.utils.PageUtil;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Scope("session")
public class PerguntaBean {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ApplicationContext contexto;

    private Pergunta pergunta;
    private List<Pergunta> listaPerguntas;
    private Integer disciplinaId;

    @PostConstruct
    public void inicializarDados() {
        pergunta = new Pergunta();
        pergunta.setDisciplina(new Disciplina());
        listaPerguntas = perguntaRepository.findAll();
        disciplinaId = null;
    }

    @Transactional
    public String salvarPergunta() {
        UsuarioBean bean = (UsuarioBean) contexto.getBean("usuarioBean");
        pergunta.setDisciplina(disciplinaRepository.findOne(disciplinaId));
        pergunta.setNumeroDeslikes(0);
        pergunta.setNumeroLikes(0);
        pergunta.setUsuario(bean.getUsuario());
        perguntaRepository.save(pergunta);
        inicializarDados();
        return PageUtil.FORUM_PAGE;
    }

    public List<Disciplina> getDisciplinas() {
        UsuarioBean bean = (UsuarioBean) contexto.getBean("usuarioBean");
        return bean.getUsuario().getDisciplinas();
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Pergunta getPergunta() {
        if (pergunta == null) {
            inicializarDados();
        }
        return pergunta;
    }

    public List<Pergunta> pesquisar() {

        PerguntaSpecification specification = new PerguntaSpecification();
        listaPerguntas = perguntaRepository.findAll(specification.perguntaFilter(pergunta.getTitulo()));

        pergunta = new Pergunta();

        return listaPerguntas;
    }

    public List<Pergunta> getListaPerguntas() {
        if (listaPerguntas == null) {
            listaPerguntas = pesquisar();
        }
        return listaPerguntas;
    }

    public List<Resposta> getListaRespostas(){
        return respostaRepository.findAll();
    }

    public String responder(Pergunta pergunta){
        RespostaBean rb = (RespostaBean) contexto.getBean("respostaBean");
        rb.setPergunta(pergunta);
        rb.setResposta(new Resposta());
        return PageUtil.RESPOSTA_PAGE;
    }

    public String visualizarPergunta(Pergunta pergunta){
        this.pergunta = pergunta;

        return PageUtil.VISUALIZAR_PERGUNTA_PAGE;
    }

    public void setListaPerguntas(List<Pergunta> listaPerguntas) {
        this.listaPerguntas = listaPerguntas;
    }

    public String getAddPerguntaPage() {
        return PageUtil.ADDPERGUNTA_PAGE;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}
