package com.micaelps.casadocodigo.listalivros;

import com.micaelps.casadocodigo.novolivro.Livro;

import javax.persistence.Id;
import java.io.Serializable;

public class ListaLivrosResponse implements Serializable {


    private Long id;
    private String titulo;

    public ListaLivrosResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
