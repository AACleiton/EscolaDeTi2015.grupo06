package br.unicesumar.escoladeti2015time06.Usuario;


import br.unicesumar.escoladeti2015time06.ItemsDeAcesso.ItemDeAcesso;
import br.unicesumar.escoladeti2015time06.ItemsDeAcesso.ItemDeAcessoRepository;
import br.unicesumar.escoladeti2015time06.MapRowMapper;
import br.unicesumar.escoladeti2015time06.Validacoes.ValidaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepo;
    @Autowired
    private ItemDeAcessoRepository itemDeAcessoRepo;
    //@Autowired
    //private PerfilDeUsuarioRepository perfilDeUsuarioRepo;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private ValidaUsuario validaUsuario;

   /* public void salvarUsuario(CriarUsuarioCommand command){
        ItemDeAcesso item = itemDeAcessoRepo.findOne(command.getIdItem());
        //PerfilDeUsuario perfil = perfilDeUsuarioRepo.findOne(command.getIdPerfil());
        Usuario usuario = new Usuario(command.getNome(),
                command.getSenha(),
                command.getEmail(),
                command.getStatus(),
                //perfil,
                item);

        repoUsu.save(usuario);
    }*/

    public void editarUsuario(Usuario novo){
        Usuario auxiliar = usuarioRepo.findOne(novo.getId());

        if (!validaUsuario.validaNome(novo.getNome()))
            return;

        auxiliar.setNome(novo.getNome());
        auxiliar.setEmail(novo.getEmail());
        auxiliar.setSenha(novo.getSenha());
        auxiliar.setStatus(novo.getStatus());
        usuarioRepo.save(auxiliar);
    }

    public List<Map<String, Object>> getAll(){
        List<Map<String, Object>> busca = jdbcTemplate.query(
                "select nome, login, email, senha, status from usuario", new MapSqlParameterSource(), new MapRowMapper());
        return busca;

    }

    public List<Map<String, Object>> getByName(String nome) {
        List<Map<String, Object>> busca;
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("nomeBusca", nome);
        busca = jdbcTemplate.query(
                "select nome from usuario where nome = :nomeBusca", parametros, new MapRowMapper());
        return busca;
    }

    public List<Map<String, Object>> getByLogin(String login) {
        List<Map<String, Object>> busca;
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("buscaLogin", login);
        busca = jdbcTemplate.query(
                "select login from usuario where login = :buscaLogin", parametros, new MapRowMapper());
        return busca;
    }

    public List<Map<String, Object>> getByEmail(String email) {
        List<Map<String, Object>> busca;
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("buscaEmail", email);
        busca = jdbcTemplate.query(
                "select email from usuario where email = :buscaEmail", parametros, new MapRowMapper());
        return busca;
    }







}
