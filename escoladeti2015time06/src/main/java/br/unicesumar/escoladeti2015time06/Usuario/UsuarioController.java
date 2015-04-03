package br.unicesumar.escoladeti2015time06.Usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;


    //===========================GET========================================
    @RequestMapping(method = RequestMethod.GET)
    public List<Map<String, Object>> getUsuarios(){
        return service.getAll();
    }

    @RequestMapping(value = "/buscarPorNome/{nomeUsuario}", method = RequestMethod.GET)
    public List<Map<String, Object>> getByName(@PathVariable String nomeUsuario){
        return service.getByName(nomeUsuario);
    }

    @RequestMapping(value = "/buscarPorLogin/{loginUsuario}", method = RequestMethod.GET)
    public List<Map<String, Object>> getByLogin(@PathVariable String loginUsuario){
        return service.getByLogin(loginUsuario);
    }

    @RequestMapping(value = "/buscarPorEmail/{emailUsuario}", method = RequestMethod.GET)
    public List<Map<String, Object>> getByEmail(@PathVariable String emailUsuario){
        return service.getByEmail(emailUsuario);
    }


    //=======================================POST===========================
    @RequestMapping(method = RequestMethod.POST)
    public void salvarUsuario(@RequestBody CriarUsuarioCommand usuario){
        //service.salvarUsuario;
    }


    //===============================PUT====================================
    @RequestMapping(method = RequestMethod.PUT)
    public void editarUsuario(@RequestBody Usuario usuario){
        service.editarUsuario(usuario);
    }



}
