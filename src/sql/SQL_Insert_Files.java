package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQL_Insert_Files {

    public static void insertFiles(String data[]) {
        Connection theConn = null;
        try {
            theConn = connection.MyConnection.getConnection();
            String sql =
                    "INSERT INTO files ( "
                    + " name ," //1
                    + " path ," //2
                    + " ext  ," //3
                    + " cont ," //4
                    + " last " //5
                  
                    + " ) VALUES ("
                    + " ?," //1
                    + " ?," //2
                    + " ?," //3
                    + " ?," //4
                    + " ? " //5
                    + " )";

            PreparedStatement ps = theConn.prepareStatement(sql);

            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (theConn != null) {
                    theConn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
