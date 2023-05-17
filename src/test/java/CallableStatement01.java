import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();

        //1. Örnek: Selamlama yapan bir function'ı Callable Statement ile çağırınız
        //Callable Statement adımları:

        //1. Adım: Function'ı oluşturan kodu yazınız.
        String sql = "CREATE OR REPLACE FUNCTION selamlama(x TEXT) RETURNS TEXT AS $$ \n" +
                "BEGIN RETURN 'Merhaba '|| x ||', nasılsın?'; END; $$ LANGUAGE plpgsql;";

        //2. Adım: Function kodunu çalıştırınız.
        statement.execute(sql);

        //3. Adım: Function'ı çağır:
        CallableStatement callableStatement = connection.prepareCall("{? = call selamlama(?)}");

        //4. Adım: Return için registerOutParameter() methodunu, parametreler için ise setString, setInt gibi methodları kullanınız
        callableStatement.registerOutParameter(1,Types.VARCHAR);
        callableStatement.setString(2,"Ali");












        connection.close();
        statement.close();
    }
}
