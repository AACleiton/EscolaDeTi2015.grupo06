package br.unicesumar.escoladeti2015time06.perfilDeAcesso;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfildeacesso/")
public class PerfilDeAcessoController {
    @Autowired
    private PerfilDeAcessoService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Map<String, Object>> getAll(){
        return service.getAll();
    }
    
    @RequestMapping(value="/buscanome/{nome}", method = RequestMethod.GET)
    public List<Map<String, Object>> getByName(@PathVariable String nome){
        return service.getByName(nome);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void salvarNovoPerfil(@RequestBody CriarPerfilCommand perfil){
        service.executar(perfil);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void editarPerfil(@RequestBody PerfilDeAcesso p){
        service.editarPerfil(p);
    }
    
    @RequestMapping(value = "/{nome}", method = RequestMethod.DELETE)
    public void deletarPerfil(@PathVariable Long id){
        service.deletarPerfil(id);
    }
    
}