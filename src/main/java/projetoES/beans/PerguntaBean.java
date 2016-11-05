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

import java.util.List;

@Component
@Scope("session")
public class PerguntaBean {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private ApplicationContext contexto;

    private Pergunta pergunta;

    private void  inicializarDados(){
        pergunta = new Pergunta();
    }

    public String inserirPergunta(){
        return perguntaPage();
    }

    public String perguntaPage(){
        return "/manterpergunta/incluirPergunta.xhtml?faces-redirect=true";
    }

    public String salvarPergunta(){
        UsuarioBean bean = (UsuarioBean) contexto.getBean("usuarioBean");
        pergunta.setUsuario(bean.getUsuario());
        perguntaRepository.save(pergunta);
        return null;
    }


    public List<Disciplina> getDisciplinas(){
        UsuarioBean bean = (UsuarioBean) contexto.getBean("usuarioBean");
        return bean.getUsuario().getDisciplinas();
    }

    public void setPergunta(Pergunta pergunta){ this.pergunta = pergunta; }

    public Pergunta getPergunta(){
        if (pergunta == null){
            inicializarDados();
        }
        return pergunta;
    }

}
