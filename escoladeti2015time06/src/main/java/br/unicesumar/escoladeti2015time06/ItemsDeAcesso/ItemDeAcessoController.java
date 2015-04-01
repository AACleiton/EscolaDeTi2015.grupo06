package br.unicesumar.escoladeti2015time06.ItemsDeAcesso;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@RequestMapping("rest/itemdeacesso/")
public class ItemDeAcessoController {
    
    @Autowired
    private ItemDeAcessoService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<ItemDeAcesso> getItens(){
        return service.recuperarItens();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void salvarItem(@RequestBody ItemDeAcesso i){
        service.salvarItem(i);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void excluirItem(@PathVariable Long id){
        service.excluirItem(id);
    }
    
}
