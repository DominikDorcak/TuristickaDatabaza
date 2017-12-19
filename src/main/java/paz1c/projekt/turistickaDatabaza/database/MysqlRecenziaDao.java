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
    public boolean save(Recenzia recenzia) {
        String query = "Insert into Recenzia (pouzivatel_login, lokalita_id, hodnotenie, text,datum)"
                + "values(?,?,?,?,?)";

        try {
            int ulozenych = jdbcTemplate.update(query, recenzia.getLoginPouzivatela(), recenzia.getIdLokality(), recenzia.getHodnotenie(), recenzia.getText(), recenzia.getDatum());
            return ulozenych == 1;
        } catch (Exception e) {
            return false;

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

}
