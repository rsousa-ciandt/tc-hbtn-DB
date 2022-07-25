import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {

    public static void initConnection() {
        String url = "jdbc:sqlite:./0x01/java_jdbc/sqlite_database_2022.sqlite";

        try(Connection connection = DriverManager.getConnection(url)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initConnection();
    }
}
