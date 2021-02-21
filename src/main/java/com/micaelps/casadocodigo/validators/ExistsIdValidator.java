package com.micaelps.casadocodigo.validators;

import com.micaelps.casadocodigo.novacategoria.Categoria;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

    @PersistenceContext
    private EntityManager manager;

    private String domainAttribute;
    private Class<?> klass;

    @Override
    public void initialize(ExistsId params){
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+klass.getName() +" where id=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        return !(list.isEmpty());
    }
}
