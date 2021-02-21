package com.micaelps.casadocodigo.listalivros;


import com.micaelps.casadocodigo.novolivro.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListaLivrosController {

    @PersistenceContext
    EntityManager manager;


    @Transactional
    @GetMapping(path = "/api/livros")
    public List executa() {

        List<ListaLivrosResponse> collect = manager
                .createQuery("select l from Livro l", Livro.class)
                .getResultStream()
                .map(ListaLivrosResponse::new).collect(Collectors.toList());
        return collect;
    }
}