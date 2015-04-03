package br.unicesumar.escoladeti2015time06.manterPerfilUsuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarPerfilDeUsuarioCommand {
    
       private final Long idPerfilDeAcesso;
       private final String nome;
    
    @JsonCreator
    public CriarPerfilDeUsuarioCommand(@JsonProperty("nome") String nome,
                                       @JsonProperty("idPerfilAcesso") Long idPerfilDeAcesso)
            
    {
        this.idPerfilDeAcesso = idPerfilDeAcesso;
        this.nome = nome;
    }   

    public Long getIdPerfilDeAcesso() {
        return idPerfilDeAcesso;
    }

    public String getNome() {
        return nome;
    }      
}
