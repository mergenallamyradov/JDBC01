import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.
        String sql1 = "SELECT company, number_of_employees  FROM companies ORDER BY number_of_employees DESC OFFSET 1 LIMIT 1";
        ResultSet resultSet = statement.executeQuery(sql1);
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1)+"--"+resultSet.getObject(2));
        }


        connection.close();
        statement.close();
    }
}
