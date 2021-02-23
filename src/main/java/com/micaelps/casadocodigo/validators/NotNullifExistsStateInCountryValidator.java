package com.micaelps.casadocodigo.validators;

import com.micaelps.casadocodigo.pagamento.novocliente.NovoClienteRequest;
import com.micaelps.casadocodigo.paisestado.Estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullifExistsStateInCountryValidator implements ConstraintValidator<NotNullifExistsStateInCountry, NovoClienteRequest> {

    @PersistenceContext
    private EntityManager manager;

    private String domainAttribute;
    private Class<?> klass;



    @Override
    public void initialize(NotNullifExistsStateInCountry constraintAnnotation) {

    }

    @Override
    public boolean isValid(NovoClienteRequest value, ConstraintValidatorContext context) {
        Query query = manager.createNativeQuery("select id, pais_id, nome from Estado where pais_id=:paisId", Estado.class);
        query.setParameter("paisId",value.getPais());
        Boolean listaVaziaEstadoVazio = (query.getResultList().isEmpty()) && (value.getEstado()==null);
        Boolean listaPreenchidaEstadoPresente = !(query.getResultList().isEmpty()) && !(value.getEstado()==null);

        return listaPreenchidaEstadoPresente|| listaVaziaEstadoVazio;
    }
}
