package br.unicesumar.escoladeti2015time06.ItemsDeAcesso;

import org.springframework.stereotype.Component;

@Component
public class CarregarItensDeAcessoPadrao {
    
    public void salvarItensPadrao(){
        ItemDeAcessoService padrao = new ItemDeAcessoService();
        
        ItemDeAcesso item01 = new ItemDeAcesso();
        ItemDeAcesso item02 = new ItemDeAcesso();
        ItemDeAcesso item03 = new ItemDeAcesso();
        ItemDeAcesso item04 = new ItemDeAcesso();
        ItemDeAcesso item05 = new ItemDeAcesso();
        ItemDeAcesso item06 = new ItemDeAcesso();
        ItemDeAcesso item07 = new ItemDeAcesso();
        ItemDeAcesso item08 = new ItemDeAcesso();
        
        item01.setDescricao("Controle de estoque");
        item02.setDescricao("Cartao de credito");
        item03.setDescricao("Conta Corrente");
        item04.setDescricao("Banco");
        item05.setDescricao("Relatório de lucros");
        item06.setDescricao("Relatório de despesas");
        item07.setDescricao("Produto");
        item08.setDescricao("Gerenciar Produto");
        
        padrao.salvarItem(item01);
        padrao.salvarItem(item02);
        padrao.salvarItem(item03);
        padrao.salvarItem(item04);
        padrao.salvarItem(item05);
        padrao.salvarItem(item06);
        padrao.salvarItem(item07);
        padrao.salvarItem(item08);
        
        
    }
}
