package paz1c.projekt.turistickaDatabaza.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author dominik
 */
public class MysqlLokalitaDao implements LokalitaDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlLokalitaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Lokalita> getSchvalena() {
        String query = "select l.id, l.region, l.popis, l.schvalena, l.nazov, o.id as obrazok_id "
                + "from Lokalita l left outer join Obrazok o on o.Lokalita_id = l.id;";

        return jdbcTemplate.query(query, new ResultSetExtractor<List<Lokalita>>() {
            @Override
            public List<Lokalita> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Lokalita> lokality = new ArrayList<>();
                Lokalita lokalita = null;
                while (rs.next()) {
                    Long lokalitaId = rs.getLong("id");
                    int schvalena = rs.getInt("schvalena");
                    if ((lokalita == null || !(lokalita.getId() == lokalitaId)) && schvalena == 1) {
                        lokalita = new Lokalita();
                        lokalita.setId(lokalitaId);
                        lokalita.setRegion(rs.getString("region"));
                        lokalita.setNazov(rs.getString("nazov"));
                        lokalita.setSchvalena(true);
                        lokalita.setPopis(rs.getString("popis"));
                        fillRecenzie(lokalita);
                        lokality.add(lokalita);
                    }
                    Long obrazokId = rs.getLong("obrazok_id");
                    if (lokalita != null && obrazokId != 0) {
                        lokalita.getObrazky().add(obrazokId);
                    }

                }
                return lokality;
            }
        });
    }

    @Override
    public List<Lokalita> getNaSchvalenie() {
        String query = "select l.id, l.region, l.popis, l.schvalena, l.nazov, o.id as obrazok_id "
                + "from Lokalita l left outer join Obrazok o on o.Lokalita_id = l.id;";

        return jdbcTemplate.query(query, new ResultSetExtractor<List<Lokalita>>() {
            @Override
            public List<Lokalita> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Lokalita> lokality = new ArrayList<>();
                Lokalita lokalita = null;
                while (rs.next()) {
                    Long lokalitaId = rs.getLong("id");
                    int schvalena = rs.getInt("schvalena");
                    if ((lokalita == null || !(lokalita.getId() == lokalitaId)) && schvalena == 0) {
                        lokalita = new Lokalita();
                        lokalita.setId(lokalitaId);
                        lokalita.setRegion(rs.getString("region"));
                        lokalita.setNazov(rs.getString("nazov"));
                        lokalita.setSchvalena(false);
                        lokalita.setPopis(rs.getString("popis"));
                        lokality.add(lokalita);
                    }
                    Long obrazokId = rs.getLong("obrazok_id");
                    if (lokalita != null && obrazokId != 0) {
                        lokalita.getObrazky().add(obrazokId);
                    }

                }
                return lokality;
            }
        });
    }

    @Override
    public void fillRecenzie(Lokalita lokalita) {
        String query = "Select lokalita_id,pouzivatel_login,text,datum,hodnotenie from Recenzia "
                + "where lokalita_id = " + lokalita.getId() + ";";
        lokalita.setRecenzie(jdbcTemplate.query(query, new ResultSetExtractor<List<Recenzia>>() {
            @Override
            public List<Recenzia> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Recenzia> recenzie = new ArrayList<>();
                while (rs.next()) {
                    Recenzia recenzia = new Recenzia();
                    recenzia.setIdLokality(lokalita.getId());
                    recenzia.setLoginPouzivatela(rs.getString("pouzivatel_login"));
                    recenzia.setText(rs.getString("text"));
                    recenzia.setHodnotenie(rs.getInt("hodnotenie"));
                    recenzia.setDatum(Timestamp.valueOf(rs.getString("datum")));

                }
                return recenzie;
            }
        }));

    }

    @Override
    public Lokalita getById(Long id) {
        List<Lokalita> lokality = getSchvalena();
        lokality.addAll(getNaSchvalenie());
        for (Lokalita lokalita : lokality) {
            if (lokalita.getId() == id) {
                return lokalita;
            }

        }
        return null;
    }

    @Override
    public void saveNew(Lokalita l) {
        String query = "insert into Lokalita(Nazov,popis,region,schvalena) Values (?,?,?,0);";
        jdbcTemplate.update(query, l.getNazov(), l.getPopis(), l.getRegion());
    }
}
