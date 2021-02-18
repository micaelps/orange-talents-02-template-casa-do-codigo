package com.micaelps.casadocodigo.novacategoria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class NovaCategoriaController {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @PostMapping(value = "/categorias")
    public void executa(@RequestBody @Valid  NovaCategoriaRequest novaCategoria){
        Categoria categoria  = novaCategoria.toModel();
        entityManager.persist(categoria);

    }
}
