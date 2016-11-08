package projetoES.persistence.specifications;


import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import projetoES.model.entities.Pergunta;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PerguntaSpecification {

    public static Specification<Pergunta> perguntaFilter(String titulo) {
        return new Specification<Pergunta>() {

            List<Predicate> predicates = new ArrayList<>();

            public Predicate toPredicate(Root<Pergunta> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {

                predicates.add(builder.like(root.get("titulo"), "%" + titulo + "%"));

                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
