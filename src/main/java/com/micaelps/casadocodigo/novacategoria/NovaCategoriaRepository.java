package com.micaelps.casadocodigo.novacategoria;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NovaCategoriaRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
