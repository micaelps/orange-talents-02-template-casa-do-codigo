package com.micaelps.casadocodigo.pagamento.novocliente;

import com.micaelps.casadocodigo.paisestado.Estado;
import com.micaelps.casadocodigo.paisestado.Pais;
import com.micaelps.casadocodigo.validators.NotNullifExistsStateInCountry;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public Cliente(@Email String email,
                   @NotBlank String nome,
                   @NotBlank String sobrenome,
                   String documento,
                   @NotBlank String endereco,
                   @NotBlank String complemento,
                   @NotBlank String cidade,
                   @NotNull Pais pais,
                   Estado estado,
                   @NotBlank String telefone,
                   @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }
}
