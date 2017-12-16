package paz1c.projekt.turistickaDatabaza.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import paz1c.projekt.turistickaDatabaza.DaoFactory;

public class MysqlPouzivatelDao implements PouzivatelDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlPouzivatelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pouzivatel> getAll() {
        String query = "select  p.login, p.heslo, p.email ,p.admin,o.Lokalita_id "
                + "from Pouzivatel p left outer join Oblubene o "
                + "on  o.Pouzivatel_login = p.login ;";

        return jdbcTemplate.query(query, new ResultSetExtractor<List<Pouzivatel>>() {
            @Override
            public List<Pouzivatel> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Pouzivatel> pouzivatelia = new ArrayList<>();
                Pouzivatel pouzivatel = null;
                while (rs.next()) {
                    String pouzivatelLogin = rs.getString("login");
                    if (pouzivatel == null || !(pouzivatel.getLogin().equals(pouzivatelLogin))) {
                        pouzivatel = new Pouzivatel();
                        pouzivatel.setLogin(pouzivatelLogin);
                        pouzivatel.setEmail(rs.getString("email"));
                        pouzivatel.setHeslo(rs.getString("heslo"));
                        if (rs.getInt("admin") == 1) {
                            pouzivatel.setAdmin(true);
                        }
                        pouzivatelia.add(pouzivatel);
                    }
                    Long lokalitaId = rs.getLong("Lokalita_id");
                    if (lokalitaId != 0) {
                        pouzivatel.getOblubene().add(
                                DaoFactory.INSTANCE.getLokalitaDao().getById(lokalitaId));
                    }

                }
                return pouzivatelia;
            }
        });

    }

    @Override
    public Pouzivatel getByLogin(String login) {
        /* List<Pouzivatel> pouzivatelia = getAll();
        for (Pouzivatel pouzivatel : pouzivatelia) {
        if(pouzivatel.getLogin().equals(login))
        return pouzivatel;
        }
        return null;*/

        String query = "select  p.login, p.heslo, p.email ,p.admin,o.Lokalita_id "
                + "from Pouzivatel p left outer join Oblubene o "
                + "on  o.Pouzivatel_login = p.login where p.login = '" + login + "';";

        List<Pouzivatel> list = jdbcTemplate.query(query, new ResultSetExtractor<List<Pouzivatel>>() {
            @Override
            public List<Pouzivatel> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Pouzivatel> pouzivatelia = new ArrayList<>();
                Pouzivatel pouzivatel = null;
                while (rs.next()) {
                    String pouzivatelLogin = rs.getString("login");
                    if (pouzivatel == null || !(pouzivatel.getLogin().equals(pouzivatelLogin))) {
                        pouzivatel = new Pouzivatel();
                        pouzivatel.setLogin(pouzivatelLogin);
                        pouzivatel.setEmail(rs.getString("email"));
                        pouzivatel.setHeslo(rs.getString("heslo"));
                        if (rs.getInt("admin") == 1) {
                            pouzivatel.setAdmin(true);
                        }
                        pouzivatelia.add(pouzivatel);
                    }
                    Long lokalitaId = rs.getLong("Lokalita_id");
                    if (lokalitaId > 0) {
                        pouzivatel.getOblubene().add(
                                DaoFactory.INSTANCE.getLokalitaDao().getById(lokalitaId));
                    }

                }
                return pouzivatelia;
            }
        });
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void saveNew(Pouzivatel pouzivatel) {
        String query = "INSERT INTO TuristickaDatabaza.Pouzivatel(login,email,heslo,admin) VALUES (?,?,?,0)";
        jdbcTemplate.update(query, pouzivatel.getLogin(), pouzivatel.getEmail(), pouzivatel.getHeslo());

    }

    @Override
    public boolean povysByLogin(String login) {
        String query = "UPDATE TuristickaDatabaza.Pouzivatel set admin = 1 where login = '" + login + "';";
        try {
            int povysenych = jdbcTemplate.update(query);
            return povysenych == 1;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean deleteByLogin(String login) {
        String query = "Delete from TuristickaDatabaza.Pouzivatel where login = '" + login + "';";
        try {
            int zmazanych = jdbcTemplate.update(query);
            return zmazanych == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
     public boolean pridajOblubenu(Lokalita lokalita,Pouzivatel pouzivatel) {
         pouzivatel.getOblubene().add(lokalita);
         String query = "Insert into Oblubene(Lokalita_id,Pouzivatel_login) values ("
                +lokalita.getId()  + ",'" + pouzivatel.getLogin() +  "');";
        try {
            int pridanych = jdbcTemplate.update(query);
            return pridanych == 1;
        } catch (Exception e) {
            return false;
        }
    }
}
