package com.micaelps.casadocodigo.novolivro;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoLivroController {


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path = "livros")
    public String executa(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
        Livro livro = novoLivroRequest.toModel(entityManager);
        entityManager.persist(livro);
        return novoLivroRequest.toString();
    }


}
