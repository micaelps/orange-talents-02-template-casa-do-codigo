package com.micaelps.casadocodigo.paisestado;

import com.micaelps.casadocodigo.validators.ExistsId;
import com.micaelps.casadocodigo.validators.ExistsStateByCountry;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

@ExistsStateByCountry(message="{State.by.country}")
public class NovoEstadoRequest {

    @NotBlank
    private String nome;
    @ExistsId(domainClass = Pais.class)
    private Long pais;

    public Estado toModel(EntityManager em) {
        Pais paisBuscado = em.find(Pais.class, pais);
        return new Estado(nome, paisBuscado);
    }


    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }
}
