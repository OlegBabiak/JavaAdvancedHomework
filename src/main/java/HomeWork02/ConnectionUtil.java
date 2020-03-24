package HomeWork02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String USERNAME = "Oleg";
    private static final String PASSWORD = "654321";
    private static final String URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&serverTimezone=UTC";



    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't connect to DB");
        }


    }

}
