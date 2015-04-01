package br.unicesumar.escoladeti2015time06.ItemsDeAcesso;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemDeAcessoService {
    
    @Autowired
    private ItemDeAcessoRepository persistence;
    
    public void salvarItem(ItemDeAcesso i){
        persistence.save(i);
    }
    
    public ItemDeAcesso recuperarPeloId(Long id){
        return persistence.findOne(id);
    }
    
    public ItemDeAcesso recuperarPorSQL(Long id){
        return null;// To do
    }
    
    public List<ItemDeAcesso> recuperarItens(){
        return persistence.findAll();
    }
    
    public void excluirItem(ItemDeAcesso i){
        persistence.delete(i);
    }
    
    public void excluirItem(Long id){
        persistence.delete(id);
    }
}
