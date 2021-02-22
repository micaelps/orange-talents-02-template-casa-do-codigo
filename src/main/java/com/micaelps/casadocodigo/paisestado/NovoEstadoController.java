package com.micaelps.casadocodigo.paisestado;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
public class NovoEstadoController {


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path = "/estados")
        public void executa(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
        Estado estado = novoEstadoRequest.toModel(entityManager);
        entityManager.persist(estado);
        }
}
