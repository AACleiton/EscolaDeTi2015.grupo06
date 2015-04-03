package br.unicesumar.escoladeti2015time06.Usuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Douglas on 03/04/2015.
 */
public class CriarUsuarioCommand {


    private final String nome;
    private final String senha;
    private final String email;
    private final Status status;
    //private final Long idPerfil;
    private final Long idItem;

    @JsonCreator
    public CriarUsuarioCommand(@JsonProperty("nome") String nome,
                               @JsonProperty("senha") String senha,
                               @JsonProperty("email") String email,
                               @JsonProperty("status") Status status,
                              // @JsonProperty("idPerfil") Long idPerfil,
                               @JsonProperty("idItem") Long idItem) {

        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.status = status;
        //this.idPerfil = idPerfil;
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

   /* public Long getIdPerfil() {
        return idPerfil;
    }*/

    public Long getIdItem() {
        return idItem;
    }

    public Status getStatus() {
        return status;
    }
}
