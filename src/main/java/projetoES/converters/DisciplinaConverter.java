package projetoES.converters;

import org.springframework.stereotype.Component;
import projetoES.model.entities.Disciplina;
import projetoES.model.entities.Pergunta;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.Map;

@Component("disciplinaConverter")
public class DisciplinaConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s != null) {
            return this.getAttributesFrom(uiComponent).get(s);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o != null) {
            Disciplina disciplina = (Disciplina) o;
            return disciplina.getNome();
        }
        return null;
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

}
