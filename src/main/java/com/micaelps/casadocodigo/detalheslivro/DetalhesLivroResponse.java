package com.micaelps.casadocodigo.detalheslivro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.micaelps.casadocodigo.novacategoria.Categoria;
import com.micaelps.casadocodigo.novoautor.Autor;
import com.micaelps.casadocodigo.novolivro.Livro;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesLivroResponse {


    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal precoLivro;

    private Integer numeroPaginas;

    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    private String nomeAutor;


    public DetalhesLivroResponse(String titulo, String resumo, String sumario, BigDecimal precoLivro, Integer numeroPaginas, String isbn, LocalDate dataPublicacao,  String nomeAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.nomeAutor = nomeAutor;
    }

    public DetalhesLivroResponse(Livro livro) {

        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.precoLivro = livro.getPrecoLivro();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn =livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.nomeAutor = livro.getAutor().getNome();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPrecoLivro() {
        return precoLivro;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getAutor() {
        return nomeAutor;
    }
}
