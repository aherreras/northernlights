package muzamia.northernlights.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author parainformaticos.com
 */
public class ConectaDb {

    public Connection getConnection() throws SQLException {
        Connection cn = null;

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }

        return cn;
    }

    public ConectaDb() {
    }

    private final String url = "jdbc:mysql://localhost:3306/muzamia";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String password = "mysql";
}
