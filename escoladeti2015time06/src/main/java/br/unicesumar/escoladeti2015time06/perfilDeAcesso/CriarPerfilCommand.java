package br.unicesumar.escoladeti2015time06.perfilDeAcesso;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CriarPerfilCommand {

    private final String nome;
    private final List<Long> idItens;

    @JsonCreator
    public CriarPerfilCommand(@JsonProperty("nome") String nome,
            @JsonProperty("idItens") List<Long> idItens) {

        this.nome = nome;
        this.idItens = idItens;
    }

    public String getNome() {
        return nome;
    }

    public List<Long> getIdItens() {
        return idItens;
    }
    
    

}
