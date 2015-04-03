package br.unicesumar.escoladeti2015time06.perfilDeAcesso;

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
public class PerfilDeAcessoService {

    @Autowired
    private PerfilDeAcessoRepository perfilRepo;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> perfis = jdbcTemplate.query(
                "select p.id,"
                + "p.nome"
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

    void salvarNovoPerfil(PerfilDeAcesso p) {
        perfilRepo.save(p);
    }

    void editarPerfil(PerfilDeAcesso p) {
        perfilRepo.save(p);
    }

    void deletarPerfil(Long id) {
        perfilRepo.delete(id);
    }

}
