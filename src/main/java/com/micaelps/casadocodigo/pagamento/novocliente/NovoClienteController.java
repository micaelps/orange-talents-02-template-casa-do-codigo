package com.micaelps.casadocodigo.pagamento.novocliente;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class NovoClienteController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping(path = "/clientes")
    public Long executa(@RequestBody @Valid NovoClienteRequest novoClienteRequest) {
        Cliente cliente = novoClienteRequest.toModel(entityManager);
        entityManager.persist(cliente);
        return cliente.getId();
    }
}
