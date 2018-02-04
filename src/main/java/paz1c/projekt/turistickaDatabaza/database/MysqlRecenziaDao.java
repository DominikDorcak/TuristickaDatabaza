package paz1c.projekt.turistickaDatabaza.database;

import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author dominik
 */
public class MysqlRecenziaDao implements RecenziaDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlRecenziaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Recenzia recenzia) {
        if (recenzia.getId() == null) {
            SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

            simpleJdbcInsert.withTableName("Recenzia");
            simpleJdbcInsert.usingGeneratedKeyColumns("id");
            simpleJdbcInsert.usingColumns("pouzivatel_login", "lokalita_id", "hodnotenie", "text", "datum");
            Map<String, Object> data = new HashMap<>();
            data.put("pouzivatel_login", recenzia.getLoginPouzivatela());
            data.put("lokalita_id", recenzia.getIdLokality());
            data.put("hodnotenie", recenzia.getHodnotenie());
            data.put("text", recenzia.getText());
            data.put("datum", recenzia.getDatum());
            recenzia.setId(simpleJdbcInsert.executeAndReturnKey(data).longValue());
        }else{
            update(recenzia);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        String query = "delete from Recenzia where id = " + id + ";";
        try {
            int vymazanych = jdbcTemplate.update(query);
            return vymazanych == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void update(Recenzia recenzia) {
        String query = "update Recenzia set text = '" + recenzia.getText()
                + "',datum = '" + recenzia.getDatum().toString() + "',hodnotenie = '" + recenzia.getHodnotenie() + "'where id = " + recenzia.getId() + ";";

        jdbcTemplate.update(query);
    }

}
