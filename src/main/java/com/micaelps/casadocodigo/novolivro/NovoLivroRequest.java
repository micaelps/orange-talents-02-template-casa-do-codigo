package com.micaelps.casadocodigo.novolivro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.micaelps.casadocodigo.novacategoria.Categoria;
import com.micaelps.casadocodigo.novoautor.Autor;
import com.micaelps.casadocodigo.validators.ExistsId;
import com.micaelps.casadocodigo.validators.UniqueValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @Size(max = 500)
    private String resumo;

    @Lob
    private String sumario;

    @Min(20)
    @NotNull
    private BigDecimal precoLivro;

    @Min(20)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class)
    private Long categoria;

    @NotNull
    private Long autor;

    public NovoLivroRequest() {

    }

    public NovoLivroRequest(@NotBlank String titulo, @Size(max = 500) String resumo, String sumario, @Min(20) @NotNull BigDecimal precoLivro, @Min(20) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Long categoria, @NotNull Long autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro toModel(EntityManager em) {
        Categoria categoriaEntity = em.find(Categoria.class, this.categoria);
        Autor autorEntity = em.find(Autor.class, this.autor);

        return  new Livro(titulo, resumo, sumario,precoLivro, numeroPaginas, isbn, dataPublicacao, categoriaEntity , autorEntity);
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

    public Long getCategoria() {
        return categoria;
    }

    public Long getAutor() {
        return autor;
    }
}
