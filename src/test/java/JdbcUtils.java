import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    //Bu class'ta tekrarlı kullanılacak methodlar oluşturacağız.
    private static Connection connection;
    private static Statement statement;

    //Database'e bağlanma methodu --> Connection return yapar
    public static Connection connectToDataBase() {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return connection;

    }

    // Statement oluşturma methodu --> Statement return yapar
    public static Statement createStatement() {

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;

    }

    //execute() methodu ile Query çalıştıran method
    public static boolean execute(String sql) {

        try {
            return statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //executeQuery ve executeUpdate methodları ödev:

}

