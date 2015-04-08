package br.unicesumar.escoladeti2015time06.ItemsDeAcesso;

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
public class ItemDeAcessoService {

    @Autowired
    private ItemDeAcessoRepository itemDeAcessoRepo;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void salvarItem(ItemDeAcesso i) {
        itemDeAcessoRepo.save(i);
    }

    public List<Map<String, Object>> recuperarItemsPorNome(String nome) {
        List<Map<String, Object>> busca;
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("nomeBusca", nome);
        busca = jdbcTemplate.query(
                "select nome from itemdeacesso where nome = :nomeBusca", parametros, new MapRowMapper());
        return busca;
    }

    public List<Map<String, Object>> recuperarItens() {
        List<Map<String, Object>> busca;
        busca = jdbcTemplate.query(
                "select id, nome from itemdeacesso", new MapRowMapper());
        return busca;
    }

}

