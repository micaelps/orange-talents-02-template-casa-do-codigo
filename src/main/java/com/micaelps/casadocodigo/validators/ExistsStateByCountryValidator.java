package com.micaelps.casadocodigo.validators;

import com.micaelps.casadocodigo.paisestado.Estado;
import com.micaelps.casadocodigo.paisestado.NovoEstadoRequest;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.List;

public class ExistsStateByCountryValidator implements ConstraintValidator<ExistsStateByCountry, NovoEstadoRequest> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsStateByCountry params) {
    }

    
    @Override
    public boolean isValid(NovoEstadoRequest estado, ConstraintValidatorContext context) {
        Query query = manager.createNativeQuery("select id, pais_id, nome from Estado where pais_id=:paisId and nome=:nome", Estado.class);
        query.setParameter("paisId",estado.getPais());
        query.setParameter("nome",estado.getNome());
        return query.getResultList().isEmpty();
    }
}
