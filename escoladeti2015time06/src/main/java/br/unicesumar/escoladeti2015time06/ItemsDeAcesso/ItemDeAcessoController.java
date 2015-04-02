package br.unicesumar.escoladeti2015time06.ItemsDeAcesso;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@RequestMapping("rest/itemdeacesso/")
public class ItemDeAcessoController {

    @Autowired
    private ItemDeAcessoService service;
    
    @PostConstruct
    //@RequestMapping(method = RequestMethod.POST)
    public void salvarItem() {
        try {
            ItemDeAcesso item01 = new ItemDeAcesso();
            ItemDeAcesso item02 = new ItemDeAcesso();
            ItemDeAcesso item03 = new ItemDeAcesso();
            ItemDeAcesso item04 = new ItemDeAcesso();
            ItemDeAcesso item05 = new ItemDeAcesso();
            ItemDeAcesso item06 = new ItemDeAcesso();
            ItemDeAcesso item07 = new ItemDeAcesso();
            ItemDeAcesso item08 = new ItemDeAcesso();
            
            item01.setNome("Controle de estoque");
            
            item02.setNome("Cartao de credito");
            
            item03.setNome("Conta Corrente");
           
            item04.setNome("Banco");
            
            item05.setNome("Relatório de lucros");
            
            item06.setNome("Relatório de despesas");
            
            item07.setNome("Produto");
            
            item08.setNome("Gerenciar Produto");
            
            
            service.salvarItem(item01);
            service.salvarItem(item02);
            service.salvarItem(item03);
            service.salvarItem(item04);
            service.salvarItem(item05);
            service.salvarItem(item06);
            service.salvarItem(item07);
            service.salvarItem(item08);
        } catch (Exception e) {
            e.printStackTrace();
            SpringApplication.exit(null, null);
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ItemDeAcesso> getItens() {
        return service.recuperarItens();
    }

    @RequestMapping(value = "/buscanome/{nome}", method = RequestMethod.GET)
    public List<Map<String, Object>> buscarItemPorNome(@PathVariable String nome){
        return service.recuperarPorSQL(nome);
    }

}