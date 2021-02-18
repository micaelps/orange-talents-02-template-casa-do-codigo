package com.micaelps.casadocodigo.novoautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {


    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;


    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }



	public Autor toModel() {
        return new Autor(nome, email, descricao);
	}

    public String getEmail() {
        return this.email;
    }
}
