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
        String sql = sqlPorEstado(value);
        Query query = manager.createNativeQuery(sql, Estado.class);
        setQuery(value, query);
        Boolean listaVaziaEstadoVazio = (query.getResultList().isEmpty()) && (value.getEstado()==null);
        Boolean listaPreenchidaEstadoPresente = !(query.getResultList().isEmpty()) && !(value.getEstado()==null);

        return listaPreenchidaEstadoPresente|| listaVaziaEstadoVazio;
    }

    private void setQuery(NovoClienteRequest value, Query query) {
        query.setParameter("paisId", value.getPais());
        if(value.getEstado()!=null){
        query.setParameter("estadoId", value.getEstado());
        }
    }

    private String sqlPorEstado(NovoClienteRequest value) {
        String sql;
        if(value.getEstado()!=null){
            sql = "select id, pais_id, nome from Estado where pais_id=:paisId and id =:estadoId";
        }else {
            sql = "select id, pais_id, nome from Estado where pais_id=:paisId";
        }
        return sql;
    }
}
