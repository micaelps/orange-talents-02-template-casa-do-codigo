package com.micaelps.casadocodigo.novacategoria;


import com.micaelps.casadocodigo.novoautor.Autor;
import com.micaelps.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public NovaCategoriaRequest(String nome) {
        this.nome = nome;
    }

    public NovaCategoriaRequest() {
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
