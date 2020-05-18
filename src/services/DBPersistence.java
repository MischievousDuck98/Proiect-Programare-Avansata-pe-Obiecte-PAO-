package services;

import java.sql.*;
public class DBPersistence {
    public static DBPersistence getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final static class SingletonHolder {
        private static final DBPersistence INSTANCE = new DBPersistence();
    }
    private Connection con;

    public Connection createConnection(String user, String pass) throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:oci:@localhost:1521:orcl";
            con = DriverManager.getConnection(url, user, pass);
            return con;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ResultSet passQuery(String query){
        try {
            Statement stat = con.createStatement();
            return stat.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
