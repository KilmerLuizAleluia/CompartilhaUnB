package projetoES.persistence.specifications;


import org.springframework.data.jpa.domain.Specification;
import projetoES.model.entities.Pergunta;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PerguntaSpecification implements Specification<Pergunta>{
    private Pergunta pergunta;

    public PerguntaSpecification (Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    @Override
    public Predicate toPredicate(Root<Pergunta> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        if (pergunta.getDisciplina().getNome() != null){
            predicates.add(cb.like(root.get(pergunta.getDisciplina().getNome()), "%" + pergunta.getDisciplina().getNome() + "%"));
        }

        if (pergunta.getDescricao() != null){
            predicates.add(cb.like(root.get(pergunta.getDescricao()), "%" + pergunta.getDescricao() + "%"));
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb){
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
