import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");//JDBC 4 sonrası yapmaya gerek yok

        //2. Adım: Database'e bağlan
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","gun*sir7");

        //3. Adım: Statement oluştur.
        Statement statement =  connection.createStatement();

        //4. Adım: Query çalıştır
        boolean r1=statement.execute("CREATE TABLE workers (worker_id VARCHAR(20), worker_name VARCHAR(20), worker_salary INT)");
        System.out.println(r1);









    }
}
