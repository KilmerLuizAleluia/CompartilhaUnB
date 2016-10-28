package projetoES.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import projetoES.model.entities.Disciplina;
import projetoES.model.entities.Usuario;
import projetoES.model.enums.TipoDepartamento;
import projetoES.persistence.repositories.UsuarioRepository;

import java.util.Arrays;
import java.util.List;

@Component
@Scope("session")
public class UsuarioBean {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;
    private Disciplina disciplina;

    private void inicializarDados(boolean alterarUsuario) {
        disciplina = new Disciplina();
        if (alterarUsuario) {
            usuario = new Usuario();
        }
    }

    public String salvar() {
        usuarioRepository.save(usuario);
        return welcomePage();
    }

    public List<TipoDepartamento> getDepartamentos(){
        return Arrays.asList(TipoDepartamento.values());
    }

    public void adicionarDisciplina() {
        disciplina.setUsuario(usuario);
        usuario.getDisciplinas().add(disciplina);
        inicializarDados(false);
    }

    private String welcomePage() {
        return "/welcome-page.xhtml?faces-redirect=true";
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            inicializarDados(true);
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Disciplina getDisciplina() {
        if (disciplina == null) {
            inicializarDados(false);
        }
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
