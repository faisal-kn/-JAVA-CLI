package database;

import java.sql.*;

public class sqlconnectivity {
    public Connection connectSql() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            String URL="jdbc:mysql://localhost:3306/miniproject";
            String USER="root";
            String PASS="password";
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void disconnect(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
