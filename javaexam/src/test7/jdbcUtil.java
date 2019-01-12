package test7;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {
    private static Connection con;
    static
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test7","root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
    public Connection getNewConnection()
    {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test7","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
