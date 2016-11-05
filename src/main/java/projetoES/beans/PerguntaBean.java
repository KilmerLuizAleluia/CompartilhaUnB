package projetoES.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import projetoES.model.entities.Pergunta;
import projetoES.persistence.repositories.PerguntaRepository;

@Component
@Scope("session")
public class PerguntaBean {

    @Autowired
    private PerguntaRepository perguntaRepository;

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

}
