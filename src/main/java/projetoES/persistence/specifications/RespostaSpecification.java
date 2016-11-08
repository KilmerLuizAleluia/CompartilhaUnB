package projetoES.persistence.specifications;

import org.springframework.data.jpa.domain.Specification;
import projetoES.model.entities.Resposta;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RespostaSpecification {

    public static Specification<Resposta> respostaFilter(String descricao) {
        return new Specification<Resposta>() {

            List<Predicate> predicates = new ArrayList<>();

            public Predicate toPredicate(Root<Resposta> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {

                predicates.add(builder.like(root.get("descricao"), "%" + descricao.trim() + "%"));

                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }


}
