package com.micaelps.casadocodigo.detalheslivro;


import com.micaelps.casadocodigo.novolivro.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DetalhesLivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @GetMapping(path = "/livros/{id}")
    public ResponseEntity<DetalhesLivroResponse> executa(@PathVariable Long id) {
        Livro livro = entityManager.find(Livro.class, id);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetalhesLivroResponse(livro));
    }
}
