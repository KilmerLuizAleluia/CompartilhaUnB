package projetoES.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import projetoES.model.entities.Pergunta;
import projetoES.model.entities.Resposta;
import projetoES.persistence.repositories.RespostaRepository;
import projetoES.utils.PageUtil;

import javax.persistence.Transient;

@Component
@Scope("session")
public class RespostaBean {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private ApplicationContext contexto;

    private Pergunta pergunta;
    private Resposta resposta;

    public Resposta getResposta() {
        return resposta;
    }

    @Transactional
    public String salvarResposta(){
        UsuarioBean bean = (UsuarioBean) contexto.getBean("usuarioBean");
        resposta.setUsuario(bean.getUsuario());
        resposta.setPergunta(pergunta);
        respostaRepository.save(resposta);
        resposta = new Resposta();
        return PageUtil.FORUM_PAGE;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}
