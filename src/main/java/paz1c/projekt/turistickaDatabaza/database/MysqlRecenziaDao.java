package paz1c.projekt.turistickaDatabaza.database;

import org.springframework.jdbc.core.JdbcTemplate;

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
    public void save(Recenzia recenzia) {//TODO datumy!!
        String query = "Insert into recenzia (pouzivatel_login, lokalita_id, hodnotenie, text,datum)"
                + "values(?,?,?,?,?)";

        jdbcTemplate.update(query, recenzia.getLoginPouzivatela(), recenzia.getIdLokality(), recenzia.getHodnotenie(), recenzia.getText(),recenzia.getDatum());

    }
}
