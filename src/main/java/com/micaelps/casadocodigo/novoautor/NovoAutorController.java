package com.micaelps.casadocodigo.novoautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class NovoAutorController {

    @PersistenceContext
    private EntityManager manager;


    @Transactional
    @PostMapping(value = "/autores")
    public void executa(@RequestBody @Valid NovoAutorRequest novoAutor) {
        Autor autor = novoAutor.toModel();
        manager.persist(autor);
    }

}
