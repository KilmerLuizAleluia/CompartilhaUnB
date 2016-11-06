package projetoES.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import projetoES.model.entities.Disciplina;
import projetoES.model.entities.Pergunta;
import projetoES.persistence.repositories.PerguntaRepository;
import projetoES.persistence.repositories.UsuarioRepository;
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
    private ApplicationContext contexto;

    private Pergunta pergunta;
    private List<Pergunta> listaPerguntas;

    @PostConstruct
    private void  inicializarDados() {
        pergunta = new Pergunta();
        listaPerguntas = pesquisar();

    }

    public String salvarPergunta() {
        UsuarioBean bean = (UsuarioBean) contexto.getBean("usuarioBean");
        pergunta.setNumeroDeslikes(0);
        pergunta.setNumeroLikes(0);
        pergunta.setUsuario(bean.getUsuario());
        perguntaRepository.save(pergunta);
        return null;
    }


    public List<Disciplina> getDisciplinas() {
        UsuarioBean bean = (UsuarioBean) contexto.getBean("usuarioBean");
        return bean.getUsuario().getDisciplinas();
    }

    public void setPergunta(Pergunta pergunta){
        this.pergunta = pergunta;
    }

    public Pergunta getPergunta(){
        if (pergunta == null){
            inicializarDados();
        }
        return pergunta;
    }

    public List<Pergunta> pesquisar() {
        PerguntaSpecification perguntaSpecification = new PerguntaSpecification(pergunta);
        listaPerguntas = perguntaRepository.findAll(perguntaSpecification);

        if(listaPerguntas.size() > 5){
            listaPerguntas = listaPerguntas.subList(0,5);
        }

        return listaPerguntas;
    }

    public List<Pergunta> getListaPerguntas() {
        if(listaPerguntas == null){
            listaPerguntas = pesquisar();
        }
        return listaPerguntas;
    }

    public void setListaPerguntas(List<Pergunta> listaPerguntas) {
        this.listaPerguntas = listaPerguntas;
    }

    public String getAddPerguntaPage() {
        return PageUtil.ADDPERGUNTA_PAGE;
    }

}
