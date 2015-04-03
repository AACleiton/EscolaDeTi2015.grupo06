package br.unicesumar.escoladeti2015time06.manterPerfilUsuario;

import br.unicesumar.escoladeti2015time06.MapRowMapper;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
 
@Component
@Transactional
public class PerfilDeUsuarioService {
    
    @Autowired
    private PerfilDeUsuarioRepository repository;
    
    @Autowired
    private PerfilDeAcessoRepository repositoryAcesso;
    
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
    
    public void executar(CriarPerfilDeUsuarioCommand comando) {
        PerfilDeAcesso perfilAcesso = repositoryAcesso.findOne(comando.getIdPerfilDeAcesso());
        PerfilDeUsuario perfilUsuario = new PerfilDeUsuario(comando.getNome(),perfilAcesso);
    }
    
   //public void salvarPerfilDeUsuario(PerfilDeUsuario p) {
   //  if (!repository.exists(p))
   //   repository.save(p);
   // }

    public List<PerfilDeUsuario> recuperarPerfisUsuario() {
        return repository.findAll();
    }
    
    
    //O Select nao está funcionando corretamente.
    List<Map<String, Object>> recuperarPorSQL(String nome) {
        List<Map<String, Object>> busca;
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("perfilBusca", nome);
        System.out.println(nome);
        busca = jdbc.query("select id, nome from perfilusuario where nome like '%perfilBusca%'", parametros , new MapRowMapper());
        return busca;
    }

    public void excluirPerfilUsuario(Long id) {
        repository.delete(id);
    }

    public void salvarPerfilUsuario(PerfilDeUsuario perfilUsuario) {
        repository.save(perfilUsuario);
    }
    
    
    
}
