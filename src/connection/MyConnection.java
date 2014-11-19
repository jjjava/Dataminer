package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author Hudson Schumaker
 */
public class MyConnection {

    /**
     * Metodo de conexão com o access
     * @throws Exception
     * @return Connection 
     */
    public static Connection getConnection() throws Exception {
        Driver d = (Driver) Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        
        
         /* 
            To use an already defined ODBC Datasource :     
            String URL = "jdbc:odbc:myDSN"; 
            Connection c = DriverManager.getConnection(URL, "user", "pwd");  
         */       
        
        Connection c = DriverManager.getConnection(
                "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:/Work/banco.mdb");
        return c;
    }
}