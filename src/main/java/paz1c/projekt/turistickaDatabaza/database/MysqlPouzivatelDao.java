
package paz1c.projekt.turistickaDatabaza.database;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


public class MysqlPouzivatelDao {
    
    private JdbcTemplate jdbcTemplate;
   

    public MysqlPouzivatelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Pouzivatel> getAll(){
        String query = ""
    }
    
    
    
    
    
}
