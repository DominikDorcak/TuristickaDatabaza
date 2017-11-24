
package paz1c.projekt.turistickaDatabaza;

import paz1c.projekt.turistickaDatabaza.database.PouzivatelDao;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class DaoFactory {
    
    private JdbcTemplate jdbcTemplate;
    
    private JdbcTemplate getJDBCTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("dataAccess");
            dataSource.setPassword("TuristickaDB_2");
//            dataSource.setDatabaseName("prezenckovnik");
            dataSource.setUrl("jdbc:mysql://localhost/TuristickaDatabaza?serverTimezone=Europe/Bratislava");

            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }
    
    public PouzivatelDao getPouzivatelDao(){
        return new MysqlPouzivatelDao(getJDBCTemplate());
    }
}
