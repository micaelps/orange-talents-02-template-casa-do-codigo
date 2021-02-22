package com.micaelps.casadocodigo.paisestado;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoPaisController {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @PostMapping(path = "/pais")
        public String executa(@RequestBody @Valid NovoPaisRequest novoPaisRequest) {
        Pais pais = novoPaisRequest.toModel();
        em.persist(pais);
        return novoPaisRequest.toString();
        }

}
