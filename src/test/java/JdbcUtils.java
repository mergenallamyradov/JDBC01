import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    //Bu class'ta tekrarlı yapılacak işlemlerin methodları bulunacak
    private static Connection connection;

    //Database'e bağlanma methodu
    public static Connection connectToDataBase()  {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }



}
