
package paz1c.projekt.turistickaDatabaza.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class MysqlPouzivatelDao implements PouzivatelDao {
    
    private JdbcTemplate jdbcTemplate;
   

    public MysqlPouzivatelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Pouzivatel> getAll(){
        String query = "SELECT p.login,p.heslo,p.email,p.admin,l.Nazov FROM TuristickaDatabaza.Pouzivatel p\n" +
"                LEFT OUTER JOIN TuristickaDatabaza.Oblubene o \n" +
"                ON p.login = o.pouzivatel_login\n" +
"                JOIN TuristickaDatabaza.Lokalita l ON o.lokalita_id = l.id\n" +
"                ORDER BY p.login";
        
        return jdbcTemplate.query(query, (ResultSet rs) -> {
            List<Pouzivatel> pouzivatelia = new ArrayList<>();
            Pouzivatel pouzivatel = null;
            while(rs.next()){
                String pouzivatelLogin = rs.getString("login");
                if(pouzivatel == null || pouzivatel.getLogin().equals(pouzivatelLogin)){
                    pouzivatel.setLogin(pouzivatelLogin);
                    pouzivatel.setEmail(rs.getString("email"));
                    pouzivatel.setHeslo(rs.getString("heslo"));
                    if(rs.getInt("admin")==1){
                        pouzivatel.setAdmin(true);
                    }
                    pouzivatelia.add(pouzivatel);
                }
                String lokalita = rs.getString("nazov"); 
                if(lokalita != null)
                    pouzivatel.getOblubene().add(lokalita);
                
            }
            return pouzivatelia;
        });  
        
    }
    
    @Override
    public Pouzivatel getByLogin(String login){
            List<Pouzivatel> pouzivatelia = getAll();
            for (Pouzivatel pouzivatel : pouzivatelia) {
            if(pouzivatel.getLogin().equals(login))
                return pouzivatel;
        }
            return null;
    }
    
    @Override
    public void save(Pouzivatel pouzivatel){
        String query = "INSERT INTO TuristickaDatabaza.Pouzivatel(login,email,heslo,admin) VALUES (?,?,?,0)";
        jdbcTemplate.update(query,pouzivatel.getLogin(),pouzivatel.getEmail(),pouzivatel.getHeslo());
        
    }
    
    
    
    
    
}
