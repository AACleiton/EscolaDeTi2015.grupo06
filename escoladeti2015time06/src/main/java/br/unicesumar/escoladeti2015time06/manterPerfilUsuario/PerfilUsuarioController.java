package br.unicesumar.escoladeti2015time06.manterPerfilUsuario;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil/usuario")
public class PerfilUsuarioController {
    @Autowired
    private PerfilDeUsuarioService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<PerfilDeUsuario> getPerfilUsuario(){
        return service.recuperarPerfisUsuario();
    }
   
    
    //Consertar o Select para conseguir buscar parte do nome e não inteiramente.
    @RequestMapping(value =  "/busca/{nome}",method = RequestMethod.GET)
    public List<Map<String, Object>> buscarPerfilUsuarioPorNome(@PathVariable String nome){
        return service.recuperarPorSQL(nome);
    }
    
    @RequestMapping(value = "/excluir/{id}",method = RequestMethod.DELETE)
    public void excluirPerfilUsuario(@PathVariable Long id) {
        service.excluirPerfilUsuario(id);
    }
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public void cadastrarPerfilUsuario(@RequestBody CriarPerfilDeUsuarioCommand perfilUsuario ) {
        //service.salvarPerfilUsuario(perfilUsuario);
        service.executar(perfilUsuario);
    }
    
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT)
    public void editarPerfilUSuario(@PathVariable Long id, @RequestBody CriarPerfilDeUsuarioCommand perfilUsuario){
        service.excluirPerfilUsuario(id);
        service.executar(perfilUsuario);
    }
}
