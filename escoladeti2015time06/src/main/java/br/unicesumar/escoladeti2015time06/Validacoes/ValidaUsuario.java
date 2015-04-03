package br.unicesumar.escoladeti2015time06.Validacoes;



public class ValidaUsuario {

    public boolean validaNome(String nome){
        if (nome == null)
            return false;
        else
            return true;
    }
}
