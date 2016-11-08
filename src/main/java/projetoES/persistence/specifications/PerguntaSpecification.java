package projetoES.persistence.specifications;


import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import projetoES.model.entities.Pergunta;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PerguntaSpecification {

    public static Specification<Pergunta> perguntaFilter(String titulo) {
        return new Specification<Pergunta>() {
            public Predicate toPredicate(Root<Pergunta> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {

                return builder.like(root.get("titulo"), "%" + titulo + "%");
            }
        };
    }
}
