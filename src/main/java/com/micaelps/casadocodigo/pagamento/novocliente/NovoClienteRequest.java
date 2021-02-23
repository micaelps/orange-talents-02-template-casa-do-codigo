package com.micaelps.casadocodigo.pagamento.novocliente;

import com.micaelps.casadocodigo.paisestado.Estado;
import com.micaelps.casadocodigo.paisestado.Pais;
import com.micaelps.casadocodigo.validators.CPForCNPJ;
import com.micaelps.casadocodigo.validators.NotNullifExistsStateInCountry;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NotNullifExistsStateInCountry
public class NovoClienteRequest {

    @Email
    private String email;
    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CPForCNPJ
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private Long pais;

    private Long estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;


    public NovoClienteRequest(@Email String email,
                              @NotBlank String nome,
                              @NotBlank String sobrenome,
                              String documento,
                              @NotBlank String endereco,
                              @NotBlank String complemento,
                              @NotBlank String cidade,
                              @NotNull Long pais,
                              Long estado,
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


    @Override
    public String toString() {
        return "NovoClienteForm{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public Cliente toModel(EntityManager em) {

        Estado estadoBuscado=null;
        if(estado!=null){
            estadoBuscado = em.find(Estado.class, estado);
        }
        Pais paisBuscado = em.find(Pais.class, pais);

        return new Cliente(email,
                nome,
                sobrenome,
                documento,
                endereco,
                complemento,
                cidade,
                paisBuscado,
                estadoBuscado,
                telefone,
               cep);
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }
}

