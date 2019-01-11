package test7;


public class jdbcUtil {
    public jdbcUtil()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
