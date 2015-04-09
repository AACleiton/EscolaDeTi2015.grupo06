package br.unicesumar.escoladeti2015time06.perfilDeAcesso;

import br.unicesumar.escoladeti2015time06.ItemsDeAcesso.ItemDeAcesso;
import br.unicesumar.escoladeti2015time06.ItemsDeAcesso.ItemDeAcessoRepository;
import br.unicesumar.escoladeti2015time06.MapRowMapper;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class PerfilDeAcessoService {

    @Autowired
    private PerfilDeAcessoRepository perfilDeAcessoRepo;
    @Autowired
    private ItemDeAcessoRepository itemDeAcessoRepo;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> perfis = jdbcTemplate.query(
                "select p.id, "
                + "p.nome "
                + "from perfildeacesso p", new MapSqlParameterSource(), new MapRowMapper());
        return perfis;
    }

    public List<Map<String, Object>> getByName(String nome) {
        List<Map<String, Object>> busca;
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("nomeBusca", nome);
        busca = jdbcTemplate.query(
                "select nome from perfildeacesso where nome =:nomeBusca", parametros, new MapRowMapper());

        return busca;

    }

    public void salvarNovoPerfil(PerfilDeAcesso p) {
        perfilDeAcessoRepo.save(p);
    }

    public void editarPerfil(PerfilDeAcesso p) {
        perfilDeAcessoRepo.save(p);
    }

    public void deletarPerfil(Long id) {
        perfilDeAcessoRepo.delete(id);
    }

    public void executar(CriarPerfilCommand comando) {
        
        Set<ItemDeAcesso> itens = new HashSet<>();

       for(Long id : comando.getIdItens()) {
           itens.add(itemDeAcessoRepo.findOne(id));
       }
        
       PerfilDeAcesso perfil = new PerfilDeAcesso(comando.getNome(), itens);
       perfilDeAcessoRepo.save(perfil);
    }
}
